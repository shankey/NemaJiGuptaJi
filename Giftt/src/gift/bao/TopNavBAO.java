package gift.bao;

import gift.bean.TopNavBean;
import gift.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;




public class TopNavBAO {
	
	Logger LOG = Logger.getLogger(TopNavBAO.class);
	
	
	public void execute(ModelAndView mv){
		List<TopNavBean> topNav = new ArrayList<TopNavBean>();
		
		for(String str : Constants.topList){
			LOG.info("str-> "+str);
			LOG.info("strfor ->"+Constants.map.get(str));
			
			topNav.add(getTopNavBean(str, Constants.map.get(str)));
		}
		
		mv.addObject("topNav", topNav);
		
	}
	
	private TopNavBean getTopNavBean(String categoryName, List<List<String>> li){
		TopNavBean bean = new TopNavBean();
		bean.setCategoryName(categoryName);
		bean.setSubCategory(li);
		return bean;
	}
	
	
	
	

}
