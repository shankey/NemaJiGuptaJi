package gift.controller;
 
import gift.bao.CategoryDetailBAO;
import gift.dao.GiftDAO;
import gift.model.GiftAsinDetail;
import gift.model.GiftCategory;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class DefaultController {
 
  @RequestMapping("/hi")
  public String hello2() {
	  System.out.println("Hello Nema");
    return "hello";
  }
 
  @RequestMapping(value = "/detailpage")
  public ModelAndView hello() {
	new CategoryDetailBAO().execute();
    return new ModelAndView("detailpage");
    
  }
 
}