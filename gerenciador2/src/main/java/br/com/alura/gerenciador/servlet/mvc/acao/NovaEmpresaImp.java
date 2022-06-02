package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.Persistencia;
import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

public class NovaEmpresaImp implements Acao {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
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
			String dataAbertura = request.getParameter("dtAbertura");
			String erro = null;
			
			if (Objects.isNull(dataAbertura) || dataAbertura.length() == 0) {
				erro = "Data inválida!";
				request.setAttribute("erro", erro);
				/*
				 * RequestDispatcher rd = request.getRequestDispatcher("formNovaEmpresa.jsp");
				 * rd.forward(request, response);
				 */
				return "forward:/formNovaEmpresa.jsp";
			}

			Empresa objEmpresa;
			objEmpresa = new Empresa(UUID.randomUUID(), empresa, cnpj, Persistencia.sdf1.parse(dataAbertura));
			Persistencia p = new Persistencia();
			p.adicionarEmpresa(objEmpresa);
			System.out.printf("Cadastrando nova empresa %s - %s%n", cnpj, empresa);
			/* response.sendRedirect("entrada?acao=lista"); */
			return "redirect:entrada?acao=ListaEmpresasOrdenado";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:entrada?acao=ListaEmpresasOrdenado";
	}
}
