package gift.dao;

import gift.factory.HibernateUtil;
import gift.model.GiftAsinDetail;
import gift.model.GiftCategory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GiftDAO {
	
	@SuppressWarnings("unchecked")
	public List<GiftCategory> getGiftCategory(String asin, Integer startAge, Integer endAge,
			String gender, String occasion, String relation, Float startPrice, Float endPrice)
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
			
			if(startPrice!=null && endPrice!=null){
				cr.add(Restrictions.between("price", startPrice, endPrice));
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
	
	@SuppressWarnings("unchecked")
	public List<GiftCategory> getGiftCategoryByUpdatedTime(Date time)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(GiftCategory.class);
			
			if(time!=null){
				cr.add(Restrictions.le("timeStamp", time));
				cr.addOrder(Order.asc("timestamp"));
				cr.setMaxResults(100);
			}else{
				return null;
			}
			
			
			List<GiftCategory> gc = cr.list();
			System.out.println("gift category by time = "+gc);
			
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
	
	public Long saveGiftCategory(GiftCategory category)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long cityId = null;
		try {
			transaction = session.beginTransaction();
			session.merge(category);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityId;
	}
	
	@SuppressWarnings("unchecked")
	public GiftAsinDetail getAsinDetail(String asin, Float price, String image, String title, String detailPage)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(GiftAsinDetail.class);
			
			if(asin!=null){
				cr.add(Restrictions.eq("asin", asin));
			}
			
			if(price!=null){
				cr.add(Restrictions.eq("price", price));
			}
			
			if(image!=null){
				cr.add(Restrictions.eq("image",image));
			}
			
			if(title!=null){
				cr.add(Restrictions.eq("title", title));
			}
			
			if(detailPage!=null){
				cr.add(Restrictions.eq("detailPage", detailPage));
			}
			
			
			GiftAsinDetail gc = (GiftAsinDetail)cr.uniqueResult();
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
	
	public Long saveGiftAsinDetail(GiftAsinDetail asinDetail)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long cityId = null;
		try {
			transaction = session.beginTransaction();
			asinDetail.setTimeStamp(new Date());
			session.merge(asinDetail);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityId;
	}
	
	public void updateAsinCategoryTimeStamp(GiftCategory gc)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			gc.setTimeStamp(new Date());
			session.merge(gc);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<GiftAsinDetail> getAsinDetailListByAsin(List<String> asinList)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(GiftAsinDetail.class);
			cr.add(Restrictions.in("asin", asinList));
			
			List<GiftAsinDetail> gc = cr.list();
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


}
