package control;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.Dao;
import object.Food;

public class listController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Dao dao = new Dao();
		ArrayList<Food> foods = dao.selectAllFood();
		mv.addObject("foods", foods);
		mv.setViewName("list.jsp");
		
		
		return mv;
	}

}
