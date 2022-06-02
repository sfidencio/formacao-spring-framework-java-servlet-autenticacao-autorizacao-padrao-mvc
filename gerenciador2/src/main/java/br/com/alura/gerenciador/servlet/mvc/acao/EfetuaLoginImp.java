package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.servlet.mvc.Persistencia;
import br.com.alura.gerenciador.servlet.mvc.model.Usuario;

public class EfetuaLoginImp implements Acao {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Persistencia p = new Persistencia();
		Usuario usuarioEncontrado = p.buscarUsuarioPorLogin(login);

		if (usuarioEncontrado != null) {
			if (usuarioEncontrado.isIgualLoginESenha(login, senha)) {
				//Request nao funciona, porque ciclo de vida e curto, tem que usar HttpSession, que cria session cookie que e associado as requests
				//Com HttpSession posso guardar usuario logados, produtos carrinho compras etc.
				//request.setAttribute("usuarioLogado", usuarioEncontrado);
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", usuarioEncontrado);
				return "redirect:entrada?acao=ListaEmpresasOrdenado"; 
			}
		}

		/*
		 * Usuario objUsuario = p.buscarIdEmpresa(id); objEmpresa.setId(id);
		 * objEmpresa.setEmpresa(empresa);
		 * objEmpresa.setDataAbertura(Persistencia.sdf.parse(dataAbertura));
		 * objEmpresa.setCnpj(cnpj); p.atualizar(objEmpresa);
		 */

		// Fazendo assim, diferente do exemplo do NovaEmpresaServlet, ao pressionar f5
		// no navegador, nao fica cadastrando executando o mesmo POST..

		/* response.sendRedirect("entrada?acao=lista"); */

		request.setAttribute("erro", "Credenciais inválidas!");
		return "forward:/formLogin.jsp";
	}
}
