package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import object.Food;


@WebServlet("/")
public class Dispatcher extends HttpServlet {
	Dao dao = new Dao();
 
    public Dispatcher() {
        super();
       
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/selectAllFood" :
			listAllFood(request,response);
		break;
		case "/selectFood" :
			listFood(request,response);
			break;
		case "/insertFood" :
			insertNewFood(request,response);
			break;
		case "/deleteFood" :
			deleteFood(request,response);
			break;
		default :
			listAllFood(request,response);
			break;
		}
	}
	//list all Food
	private void listAllFood(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Food> foods = dao.selectAllFood();
		request.setAttribute("foods", foods);
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();}
		}
	//select food by name
	private void listFood(HttpServletRequest request, HttpServletResponse response) {
		String foodName = request.getParameter("foodName");
		Food food = dao.selectFood(foodName);
		request.setAttribute("food", food);
		RequestDispatcher rd = request.getRequestDispatcher("list-food.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();}
		}
	//insert(create) new food
	private void insertNewFood(HttpServletRequest request, HttpServletResponse response) {
		String foodName = request.getParameter("foodName");
		double portionSize = Double.parseDouble(request.getParameter("portionSize"));
		double carb = Double.parseDouble(request.getParameter("carb"));
		double protein = Double.parseDouble(request.getParameter("protein"));
		double fat = Double.parseDouble(request.getParameter("fat"));
		double natrium = Double.parseDouble(request.getParameter("natrium"));
		double sugar = Double.parseDouble(request.getParameter("sugar"));
		double calories = Double.parseDouble(request.getParameter("calories"));
		dao.insertFood(foodName, portionSize, carb, protein, fat, natrium, sugar, calories);
		RequestDispatcher rd = request.getRequestDispatcher("insert-food.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();}
		}
	
	//delete food
	private void deleteFood(HttpServletRequest request, HttpServletResponse response) {
		String foodName = request.getParameter("foodName");
		dao.deleteFood(foodName);
		RequestDispatcher rd = request.getRequestDispatcher("delete-food.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();}
		}
	}

	

