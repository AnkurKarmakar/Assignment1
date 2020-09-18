package CRUD.SpringBoot.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import CRUD.SpringBoot.Model.Login;
import CRUD.SpringBoot.Service.AppService;


@Controller
public class AppController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLoginPage(Model model) {
		model.addAttribute("login", new Login());
		return new ModelAndView("login");
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showLoginPage(@ModelAttribute("login") Login model, BindingResult result) throws SQLException, IOException {
		String username = model.getUsername();
		String password = model.getPassword();
		AppService ob = new AppService();
		boolean check  = ob.authenticate(username,password);
		System.out.println(check);
		if(check == false)
			return new ModelAndView("login");
		else
		{
			ModelAndView mv = new ModelAndView();
			ArrayList<ArrayList<String>> ar = (new AppService()).getDataService();
			mv.addObject("ar",ar);
			mv.setViewName("crud");
			return mv;
			
		}
	}

}
