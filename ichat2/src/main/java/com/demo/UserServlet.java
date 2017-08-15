package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action=request.getParameter("action");		
		if("login_input".equals(action)){			
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			System.out.println("UserServlet,doGet()"+action);
		}else if("login".equals(action)){			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			PrintWriter pw=response.getWriter();
			pw.write("name->"+name+",password->"+password);
			System.out.println("name->"+name+",password->"+password);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);				
			System.out.println("UserServlet,doGet()"+action);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
