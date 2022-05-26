package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluiEmpresaServlet
 */
@WebServlet(description = "Excluir empresa", urlPatterns = { "/excluiEmpresaServlet" })
public class ExcluiEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluiEmpresaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		UUID id = UUID.fromString(request.getParameter("id"));
		Persistencia p = new Persistencia();
		if (Objects.nonNull(id)) {
			p.excluirEmpresa2(id);
		}
		
		response.sendRedirect("listaEmpresas2");
		
	}

}
