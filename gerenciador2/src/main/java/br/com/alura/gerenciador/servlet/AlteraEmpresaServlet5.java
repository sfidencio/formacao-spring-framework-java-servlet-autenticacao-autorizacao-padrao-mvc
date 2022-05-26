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
 * Servlet implementation class ExcluiEmpresaServlet
 */
@WebServlet(description = "Altera empresa", urlPatterns = { "/alteraEmpresaServlet5" })
public class AlteraEmpresaServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlteraEmpresaServlet5() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			UUID id = UUID.fromString(request.getParameter("id"));
			String empresa = request.getParameter("empresa");
			String cnpj = request.getParameter("cnpj");
			String dataAbertura = request.getParameter("dtAbertura");

			Persistencia p = new Persistencia();

			Empresa objEmpresa = p.buscarIdEmpresa(id);
			objEmpresa.setId(id);
			objEmpresa.setEmpresa(empresa);
			objEmpresa.setDataAbertura(Persistencia.sdf.parse(dataAbertura));
			objEmpresa.setCnpj(cnpj);
			
			p.atualizar(objEmpresa);
			
			//Fazendo assim, diferente do exemplo do NovaEmpresaServlet, ao pressionar f5 no navegador, nao fica cadastrando executando o mesmo POST.. 
			response.sendRedirect("listaEmpresas2");
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
