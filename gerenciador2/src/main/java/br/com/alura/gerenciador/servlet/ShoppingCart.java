package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/shopping-cart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Manda requisição no navegar assim
		 *
		 * Ex:
		 * http://localhost:8080/gerenciador/shopping-cart?productId=12&price=220.98&discount=98.58
		 */

		String productId = request.getParameter("productId");
		String discount = request.getParameter("discount");
		Double price = Double.parseDouble(request.getParameter("price"));

		price = price - Double.parseDouble(discount);

		System.out.printf("Aplicando desconto %s - %s%n", productId, discount);
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<body>" + "Desconto aplicado do produto!<br>Produto: " + productId + "<br>Preco: "
				+ price + " </body>" + "</html>");
	}

}
