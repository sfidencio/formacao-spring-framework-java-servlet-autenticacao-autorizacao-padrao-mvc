package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresas
 */
@WebServlet("/listaEmpresas2")
public class ListaEmpresasServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaEmpresasServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response)
	protected void service(HttpServletRequest request, HttpServletResponse response) //aceita tanto get quanto post
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Persistencia p = new Persistencia();
		List<Empresa> lista = p.obterTodasEmpresas();
		System.out.println("Listando empresas");

		/*lista.forEach(item -> {
			out.println("<li>");
			out.println("<span>" + item.getId() + " - " + item.getEmpresa() + "</span><br>");
			out.println("</li>");
		});*/
		
		request.setAttribute("empresas",lista);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);

	}

}
