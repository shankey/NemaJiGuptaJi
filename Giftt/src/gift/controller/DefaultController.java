package gift.controller;
 
import gift.dao.GiftDAO;
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
 
  @RequestMapping(value = "/hello")
  public ModelAndView hello() {
		
		GiftDAO giftDAO = new GiftDAO();
		List<GiftCategory> li = giftDAO.getGiftCategory(null, null, null, "M", null, null);
		System.out.println(li);
    return new ModelAndView("hello");
    
  }
 
}