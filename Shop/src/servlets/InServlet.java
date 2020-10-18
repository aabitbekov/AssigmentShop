package servlets;

import java.io.IOException;

import astanait.com.Cart;
import astanait.com.User;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InServlet")
public class InServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<User> users =new LinkedList<User>();
		users.add(new User("astanait","2020","astanait@mail.ru"));
		users.add(new User("aabitbek","almaz","almaz@mail.ru"));
		users.add(new User("admin","123","astanait@mail.ru"));
		if((String)request.getSession().getAttribute("username") !=null & (String)request.getSession().getAttribute("password") != null) {
			users.add(new User((String)request.getSession().getAttribute("username"),(String)request.getSession().getAttribute("password")));
		}
		
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		for(User user : users) {
			if(username.equals(user.getUsername()) & password.equals(user.getPassword())) {
				Cookie cookie = new Cookie("username", username);
		        cookie.setMaxAge(60*1);
		        response.addCookie(cookie);
		        
		        HttpSession session = request.getSession();
		        Integer count= (Integer)session.getAttribute("count");
		        if(count == null) {
		        session.setAttribute("count",1);
		        count = 1;
		        PrintWriter printWriter = response.getWriter();
		        printWriter.print(count);
		        }
		        else
		        session.setAttribute("count", count++);
		  
		        request.getRequestDispatcher("products.jsp").forward(request, response);
			} 
		}
		
			 PrintWriter printWriter = response.getWriter();
			 printWriter.println("sorry invalid login or password");
			 request.getRequestDispatcher("Registr.jsp").forward(request, response);
		
	
		
		
	}

}