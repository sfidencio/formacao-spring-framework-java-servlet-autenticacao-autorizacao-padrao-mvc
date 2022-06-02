package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.Persistencia;
import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

public class AlteraEmpresaImp implements Acao {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		System.out.println(request.getParameter("id"));
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
		p.atualizarEmpresa(objEmpresa);
		// Fazendo assim, diferente do exemplo do NovaEmpresaServlet, ao pressionar f5
		// no navegador, nao fica cadastrando executando o mesmo POST..
		
		/* response.sendRedirect("entrada?acao=lista"); */
		return "redirect:entrada?acao=ListaEmpresasOrdenado";
	}
}
