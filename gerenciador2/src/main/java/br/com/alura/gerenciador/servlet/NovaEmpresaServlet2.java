package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa2")
public class NovaEmpresaServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      Quando utilizo apenas doPost, so aceita requisição post, bem como doGet
	 *      so aceita requisicao get.
	 * 
	 *      No caso o metodo 'service', aceita ambos!
	 * 
	 *      Ao tentar enviar requisiçao get quando se tem apenas doPost, ele retorna
	 *      codigo http 405, nao é permitido.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			// protected void doGet(HttpServletRequest request, HttpServletResponse
			// response)
			// protected void service(HttpServletRequest request, HttpServletResponse
			// response)
			throws ServletException, IOException {
		/*
		 * Manda requisição no navegar assim
		 *
		 * Ex: http://localhost:8080/gerenciador/novaEmpresa?empresa=Alura&cnpj=
		 * 85875858985
		 * 
		 */
		try {
			String cnpj = request.getParameter("cnpj");
			String empresa = request.getParameter("empresa");
			String dataAbertura = request.getParameter("dataAbertura");

			Empresa objEmpresa;

			objEmpresa = new Empresa(UUID.randomUUID(), empresa, cnpj, Persistencia.sdf1.parse(dataAbertura));

			Persistencia p = new Persistencia();
			p.adicionar(objEmpresa);

			System.out.printf("Cadastrando nova empresa %s - %s%n", cnpj, empresa);

			// ao inves do servlet renderizar a resposta, iremos utiliza o dispacher, para
			// chamar JSP, tirando essa responsabilidade do servlet
			/*
			 * PrintWriter out = response.getWriter(); out.println("<html>" + "<body>" +
			 * "Empresa cadastrada com sucesso!<br>Id: " + objEmpresa.getId() +
			 * "<br>Empresa: " + objEmpresa.getEmpresa() + "<br>CNPJ: " +
			 * objEmpresa.getCnpj() + " </body>" + "</html>");
			 */

			RequestDispatcher rd = request.getRequestDispatcher("novaEmpresaCriada2.jsp");
			// coloca informação da empresa capturada pelo servlet, vinda do
			// formNovaEmpresa.html
			request.setAttribute("empresa", objEmpresa.getEmpresa() + " - " + objEmpresa.getCnpj());
			rd.forward(request, response);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
