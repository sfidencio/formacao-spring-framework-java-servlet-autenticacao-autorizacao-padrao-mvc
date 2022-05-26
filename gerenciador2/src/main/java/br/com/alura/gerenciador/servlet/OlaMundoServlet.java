package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/olaMundo") // Aqui mapeamos o servlet para /olaMundo
@WebServlet(urlPatterns = { "/olaMundo", "/olaMundo-divertido" }) // Aqui mapeamos o servlet para /olaMundo
public class OlaMundoServlet extends HttpServlet {

	private int i = 1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.service(req, resp);

		// resp.getOutputStream() -- caso quisesse devolver fluxo binario
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body style='color: blue;font-size:30px;'>Titulo Fluxo Servlet de nº " + (i++) + "</body>");
		out.println("</html>");
		System.out.println("Servlet chamado com sucesso!");
	}

}
