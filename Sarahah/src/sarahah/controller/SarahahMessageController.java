package sarahah.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sarahah.bean.Message;
import sarahah.bean.User;
import sarahah.dao.MessageDao;
import sarahah.dao.UserDao;

@Controller
public class SarahahMessageController {
	@Autowired
	MessageDao messagaeDao;
	@Autowired
	UserDao userdao;
	@RequestMapping(value="{userName}",method=RequestMethod.GET)
	public ModelAndView goToMessage(@PathVariable String userName,@ModelAttribute("UserDetails") User user) {
		ModelAndView model = new ModelAndView("message");
		user=userdao.showUser(userName);
		System.out.println("Name in message" +user.getName());
		//model.addAttribute("userName",user.getName());
		model.addObject("name",user.getName());
		return model;
		
	}
	@RequestMapping(value="thankyou",method=RequestMethod.POST)
	public ModelAndView sendMessage(@ModelAttribute("userMessage")Message message) {
		ModelAndView model=new ModelAndView("thankyou");
		System.out.println("user here" +message.getUserName());
		messagaeDao.saveMessage(message);
		return model;
	}
	@RequestMapping(value="mymessages",method=RequestMethod.GET)
	public ModelAndView viewMessage(HttpServletRequest request) {
		ModelAndView model=new ModelAndView("MyMessages");
		User user=(User)request.getSession().getAttribute("user");
		//System.out.println("username" +user.getUserName());
		List<Message> message=messagaeDao.viewMessage(user.getUserName());
		/** for(Message messag:message) {
		System.out.println("messages " + messag);
		for (int i=0; i<message.size(); i++) {
		System.out.println("message" + message.get(i));
		System.out.println("date" +message.get(i).getDateTime());
		}
		} **/
		model.addObject("userName", user.getUserName());
		model.addObject("name",user.getName());
		if(message !=null)
		model.addObject("message",message);
		
		return model;
	}
	

}
