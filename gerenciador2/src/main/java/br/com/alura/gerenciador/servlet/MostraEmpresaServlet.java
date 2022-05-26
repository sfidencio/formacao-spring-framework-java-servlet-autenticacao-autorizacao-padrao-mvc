package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluiEmpresaServlet
 */
@WebServlet(description = "Mostra empresa", urlPatterns = { "/mostraEmpresaServlet" })
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostraEmpresaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		UUID id = UUID.fromString(request.getParameter("id"));
		Persistencia p = new Persistencia();
		Empresa e = p.buscarIdEmpresa(id);

		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa5.jsp");
		request.setAttribute("empresa", e);
		rd.forward(request, response);
	}

}
