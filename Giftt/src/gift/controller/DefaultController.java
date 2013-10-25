package gift.controller;
 
import gift.bao.CategoryDetailBAO;
import gift.bao.TopNavBAO;
import gift.bean.DetailPageBean;
import gift.dao.GiftDAO;
import gift.model.GiftAsinDetail;
import gift.model.GiftCategory;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class DefaultController {
	
	private static Logger LOG = Logger.getLogger(DefaultController.class);
 
  @RequestMapping("/hi")
  public String hello2() {
	  LOG.info("Hello Nema");
    return "hello";
  }
 
  @RequestMapping(value = "/detailpage")
  public ModelAndView hello(
  @RequestParam(value = "age", required = false) final String age,
  @RequestParam(value = "relation", required = false) final String relation,
  @RequestParam(value = "occasion", required = false) final String occasion,
  @RequestParam(value = "startPrice", required = false) final String startPrice,
  @RequestParam(value = "endPrice", required = false) final String endPrice,
  @RequestParam(value = "gender", required = false) final String gender
  ) throws Exception {
	  File file = new File(".");
	  System.out.println("File = "+file.getAbsolutePath());
	  System.out.println(System.getProperty("catalina.base"));
	LOG.info(String.format("age %s, relation %s, occasion %s, startPrice %s, endPrice %s , gender %s", age, relation, occasion, startPrice, endPrice, gender));
	DetailPageBean bean = new DetailPageBean();
	if(age!=null){
		bean.setAge(Integer.parseInt(age));
	}
	
	if(startPrice!=null && endPrice!=null){
		bean.setStartPrice(Float.parseFloat(startPrice));
		bean.setEndPrice(Float.parseFloat(endPrice));
	}
	
	if(gender!=null){
		bean.setGender(gender);
	}
	
	if(occasion!=null){
		bean.setOccasion(occasion);
	}
	
	if(relation!=null){
		bean.setRelation(relation);
	}
	
	
	ModelAndView mv = new ModelAndView("detailpage");
	
	new CategoryDetailBAO(bean).execute(mv);
	new TopNavBAO().execute(mv);
    return mv;
    
  }
 
}