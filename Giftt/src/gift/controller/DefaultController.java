package gift.controller;
 
import gift.dao.CityDAO;

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
	  System.out.println("Hello Nema 21");
	  System.out.println("Hello Nema 3");
	  CityDAO cityDAO = new CityDAO();
   
		long cityId1 = cityDAO.saveCity("New York");
		long cityId2 = cityDAO.saveCity("Rio de Janeiro");
		long cityId3 = cityDAO.saveCity("Tokyo");
		long cityId4 = cityDAO.saveCity("London");

		cityDAO.listCities();

		cityDAO.updateCity(cityId4, "Paris");

		cityDAO.deleteCity(cityId3);

		cityDAO.listCities();
		System.out.println("Hello Nema 3");
    return new ModelAndView("hello");
    
  }
 
}