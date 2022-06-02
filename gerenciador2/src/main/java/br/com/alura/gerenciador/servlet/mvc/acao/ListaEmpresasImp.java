package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.Persistencia;
import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

public class ListaEmpresasImp implements Acao {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Persistencia p = new Persistencia();
		List<Empresa> lista = p.obterTodasEmpresas();
		System.out.println("Listando empresas");
		request.setAttribute("empresas", lista);
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		 * rd.forward(request, response);
		 */
		return "forward:/listaEmpresas.jsp";
	}
}
