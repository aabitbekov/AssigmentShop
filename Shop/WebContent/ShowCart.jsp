<%@include file = "jsp/header.jsp" %>
<%@ page import ="astanait.com.Cart" %>
<%@ page import ="java.util.List" %>
<%
List<Cart> cart = (Cart)session.getAttribute("cart");
for(Cart cartt : cart){
	%>
<p><%=cart.getMark() %> </p>
<p><%=cart.getModel()%></p>
<p><%=cart.getPrice()%></p>
<%
}
%>


%>

<%@include file = "jsp/footer.jsp" %>