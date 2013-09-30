package gift.dao;

import gift.factory.HibernateUtil;
import gift.model.City;
import gift.model.GiftCategory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GiftDAO {
	
	@SuppressWarnings("unchecked")
	public List<GiftCategory> getGiftCategory(String asin, Integer startAge, Integer endAge, String gender, String occasion, String relation)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(GiftCategory.class);
			
			if(asin!=null){
				cr.add(Restrictions.eq("asin", asin));
			}
			
			if(startAge!=null && endAge!=null){
				cr.add(Restrictions.between("age", startAge, endAge));
			}
			
			if(gender!=null){
				cr.add(Restrictions.eq("gender",gender));
			}
			
			if(occasion!=null){
				cr.add(Restrictions.eq("occasion", occasion));
			}
			
			if(relation!=null){
				cr.add(Restrictions.eq("relation", relation));
			}
			
			
			List<GiftCategory> gc = cr.list();
			System.out.println("gift category = "+gc);
			

			transaction.commit();
			
			return gc;
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public Long saveGift(String giftName)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long cityId = null;
		try {
			transaction = session.beginTransaction();
			GiftCategory category = new GiftCategory();
			category.setAsin(giftName);
			category.setAge(23);
			category.setOccasion("occ");
			category.setRelation("rel");
			session.save(category);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityId;
	}

}
