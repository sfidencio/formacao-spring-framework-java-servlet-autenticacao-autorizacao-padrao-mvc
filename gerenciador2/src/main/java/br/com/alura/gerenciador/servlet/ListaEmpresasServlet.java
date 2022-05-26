package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresas
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaEmpresasServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Persistencia p = new Persistencia();
		List<Empresa> lista = p.obterTodasEmpresas();
		System.out.println("Listando empresas");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Lista de Empresas</h2><br>");
		out.println("<lu>");
		lista.forEach(item -> {
			out.println("<li>");
			out.println("<span>" + item.getId() + " - " + item.getEmpresa() + "</span><br>");
			out.println("</li>");
		});
		out.println("</lu>");
		out.println("</body>");
		out.println("</html>");
		//out.println("");
		out.append("Serverd at: ").append(request.getContextPath());
	}

}
