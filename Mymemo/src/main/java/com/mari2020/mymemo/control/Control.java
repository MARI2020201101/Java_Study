package com.mari2020.mymemo.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mari2020.mymemo.service.DeleteService;
import com.mari2020.mymemo.service.UpdateService;
import com.mari2020.mymemo.service.ViewContentsService;
import com.mari2020.mymemo.service.ViewService;
import com.mari2020.mymemo.service.WriteService;

@Controller
public class Control {

	ModelAndView mv = new ModelAndView();

	@RequestMapping(value = "/")
	public ModelAndView viewControl(HttpServletRequest request, HttpServletResponse response) {
		ViewService vs = new ViewService();
		vs.execute(request, response);
		mv.setViewName("view");

		return mv;
	}

	  @RequestMapping(value = "/write", method = RequestMethod.GET) 
	  public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse response) {
		  mv.setViewName("writepage");
		  return mv; }
	  
	
	  @RequestMapping(value = "/write" , method = RequestMethod.POST) 
	  public String writeControl(Model model, String no ,
	  String title, String contents) { 
		  WriteService ws = new WriteService();
		  ws.execute(model, no, title, contents);
	  
		  return "redirect:/"; }
	 
		
	  @RequestMapping(value = "/view.contents" ) 
	  public String viewContentsControl(Model model, int no) { 
		  ViewContentsService vcs = new ViewContentsService(); 
		  vcs.execute(model, no); 
		  return "view-contents"; }
		
	  @RequestMapping(value = "/view.update" ,method = RequestMethod.GET ) 
	  public String updateForm(Model model, int no) { 
		  ViewContentsService vcs = new ViewContentsService(); 
		  vcs.execute(model, no); 
		  return "view-update"; }
	  
	  @RequestMapping(value = "/view.update" , method = RequestMethod.POST ) 
	  public String updateControl(Model model, String no, String title, String contents) { 
		  UpdateService us = new UpdateService();
		  us.execute(model, title, contents, no);
		  viewContentsControl(model, Integer.parseInt(no));
		  return "view-contents"; }
	  
	  @RequestMapping(value = "/delete") 
	  public String deleteControl(Model model, String no) { 
		  DeleteService ds = new DeleteService();
		  ds.execute(model, Integer.parseInt(no));

		  return "redirect:/"; }
}