package CRUD.SpringBoot.Controller;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import CRUD.SpringBoot.Model.Add;
import CRUD.SpringBoot.Model.Delete;
import CRUD.SpringBoot.Model.Login;
import CRUD.SpringBoot.Model.Update;
import CRUD.SpringBoot.Service.AppService;


@Controller
public class AppController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView goLoginPage(Model model) {
		model.addAttribute("login", new Login());
		return new ModelAndView("login");
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView goToAddPage(Model model) {
		model.addAttribute("add", new Add());
		return new ModelAndView("add");
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView goToDeletePage(Model model) {
		model.addAttribute("delete", new Delete());
		return new ModelAndView("delete");
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView goToUpdatePage(Model model) {
		model.addAttribute("update", new Update());
		return new ModelAndView("update");
	}
	@RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
	public ModelAndView goToUpdateUser(@ModelAttribute("update") Update model, BindingResult result) throws SQLException {
		int employeeid = model.getEmployeeid();
		String employeename = model.getEmployeename();
		String designation = model.getDesignation();
		double salary = model.getSalary();
		ModelAndView mv = new ModelAndView();
		AppService ob = new AppService();
		ob.update(employeeid,employeename,designation,salary);
		ArrayList<ArrayList<String>> ar = (new AppService()).getDataService();
		mv.addObject("ar",ar);
		mv.setViewName("crud");
		return mv;
	}
	@RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("delete") Delete model, BindingResult result) throws SQLException {
		int employeeid = model.getEmployeeid();
		AppService ob = new AppService();
		ob.delete(employeeid);
		ModelAndView mv = new ModelAndView();
		ArrayList<ArrayList<String>> ar = (new AppService()).getDataService();
		mv.addObject("ar",ar);
		mv.setViewName("crud");
		return mv;
	}
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("add") Add model, BindingResult result) throws SQLException {
		int employeeid = model.getEmployeeid();
		String employeename = model.getEmployeename();
		String designation = model.getDesignation();
		double salary = model.getSalary();
		AppService ob = new AppService();
		ob.add(employeeid,employeename,designation,salary);
		ModelAndView mv = new ModelAndView();
		ArrayList<ArrayList<String>> ar = (new AppService()).getDataService();
		mv.addObject("ar",ar);
		mv.setViewName("crud");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showLoginPage(@ModelAttribute("login") Login model, BindingResult result) throws SQLException{
		String username = model.getUsername();
		String password = model.getPassword();
		AppService ob = new AppService();
		boolean check  = ob.authenticate(username,password);
		//System.out.println(check);
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
