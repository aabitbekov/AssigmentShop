package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import astanait.com.Cart;
import astanait.com.Categories;

@WebServlet("/getCart")
public class getCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getCart() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session= request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	String mark = request.getParameter("mark");
	String model = request.getParameter("model");
	String price = request.getParameter("price");
	String image = request.getParameter("image");
	if(cart==null) {
		List<Cart> cart = new ArrayList<Cart>();
		cart.add(new Cart(Categories.Pnones,mark,model,price,image));
	}
	session.setAttribute("cart", cart);
	getServletContext().getRequestDispatcher("ShowCart.jsp").forward(request, response); 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
