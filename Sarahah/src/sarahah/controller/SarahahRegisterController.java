package sarahah.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sarahah.bean.User;
import sarahah.bean.UserLogin;
import sarahah.dao.UserDao;

@Controller
@Scope("session")
public class SarahahRegisterController {
	@Autowired
	UserDao userdao;
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView showIndex(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		ModelAndView model=new ModelAndView("index");
		boolean isLogin=false;
		if(user!=null) {
			isLogin=true;
			model.addObject("isLogin",isLogin);
		}
		model.addObject("isLogin",isLogin);
		return model;
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registerUser() {
		ModelAndView model=new ModelAndView("register");
		return model;
	}
	
	@RequestMapping(value="account", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userReg")User user,HttpServletRequest request) {
		ModelAndView model=new ModelAndView("home");
		userdao.saveUser(user);
		model.addObject("username",user);
		request.getSession().setAttribute("user", user);
		return model;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
		public ModelAndView loginUser() {
			ModelAndView model=new ModelAndView("login");
			return model;
	}
	@RequestMapping(value="home", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("userLogin")UserLogin userLogin,HttpServletRequest request) {
		ModelAndView model=null;
		try {
			boolean loggedInUser=userdao.isUserLogin(userLogin);
			if(loggedInUser) {
			model=new ModelAndView("home");
			User user=userdao.showUser(userLogin.getUserName());
			model.addObject("username",userLogin);
			model.addObject("user",user);
			//System.out.println("My name is" +user.getName());
			request.getSession().setAttribute("user", user);
			}
			else {
				model=new ModelAndView("login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "login";
	}
	
}
