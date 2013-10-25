package gift.bao;

import gift.bean.DetailPageBean;
import gift.dao.GiftDAO;
import gift.model.GiftAsinDetail;
import gift.model.GiftCategory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

public class CategoryDetailBAO {
	
	private static Logger LOG = Logger.getLogger(CategoryDetailBAO.class);
	
	DetailPageBean bean;
	
	
	public CategoryDetailBAO(DetailPageBean bean) {
		this.bean = bean;
	}

	public void execute(ModelAndView mv){
		GiftDAO giftDAO = new GiftDAO();
		Integer age = bean.getAge();
		Integer startAge=null;
		Integer endAge=null;
		if(age!=null){
			startAge = age-5;
			endAge = age+5;
		}
		List<GiftCategory> li = giftDAO.getGiftCategory(null, startAge, endAge, bean.getGender(), bean.getOccasion(), bean.getRelation(), bean.getStartPrice(), bean.getEndPrice());
		
		if(li==null){
			LOG.info("Categories were null");
			mv.addObject("asinDetailList", new ArrayList<GiftAsinDetail>());
			return;
		}
		
		LOG.info(li);
		List<String> asinList = extractAsinList(li);
		List<GiftAsinDetail> asinDetailList = giftDAO.getAsinDetailListByAsin(asinList);
		
		if(asinDetailList==null){
			mv.addObject("asinDetailList", new ArrayList<GiftAsinDetail>());
			return;
		}
		
		mv.addObject("asinDetailList", asinDetailList);
		
		LOG.info(asinDetailList);
		
	}
	
	private List<String> extractAsinList(List<GiftCategory> li){
		List<String> asinList = new ArrayList<String>();
		for(GiftCategory asinDetail : li){
			asinList.add(asinDetail.getAsin());
		}
		
		return asinList;
	}
	

}
