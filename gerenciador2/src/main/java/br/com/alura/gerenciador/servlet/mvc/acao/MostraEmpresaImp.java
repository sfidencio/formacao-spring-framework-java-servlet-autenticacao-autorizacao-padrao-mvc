package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.Persistencia;
import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

public class MostraEmpresaImp implements Acao {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UUID id = UUID.fromString(request.getParameter("id"));
		Persistencia p = new Persistencia();
		Empresa e = p.buscarIdEmpresa(id);
		request.setAttribute("empresa", e);

		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/formAlteraEmpresa.jsp"); rd.forward(request,
		 * response);
		 */
		return "forward:/formAlteraEmpresa.jsp";
	}
}
