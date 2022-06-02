package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.Persistencia;

public class ExcluiEmpresaImp implements Acao {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		UUID id = UUID.fromString(request.getParameter("id"));
		Persistencia p = new Persistencia();
		if (Objects.nonNull(id))
			p.excluirEmpresa2(id);
		/* response.sendRedirect("entrada?acao=lista"); */
		return "redirect:entrada?acao=ListaEmpresasOrdenado";
	}
}
