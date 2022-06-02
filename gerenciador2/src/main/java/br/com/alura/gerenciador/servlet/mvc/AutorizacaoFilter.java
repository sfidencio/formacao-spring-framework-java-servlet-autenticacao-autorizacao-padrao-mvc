package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.servlet.mvc.model.Usuario;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 * 
 * Intercepa requisicao e verifica se o usuario esta logado
 * 
 * O filtro consegue parar a execu��o, j� que ele vem como uma camada � frente
 * da aplica��o. Alternativa correta! Essa � a diferen�a que podemos ver no
 * nosso c�digo, atrav�s do par�metro FilterChain. Usamos o FilterChain para
 * mandar a requisi��o para frente.
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	
	//Versoes antigas do tomcat e jetty tem que declarar o metodo init e o destroy
	/*@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}*/
	
	/*@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}*/
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;

		String paramAcao = request2.getParameter("acao");

		Boolean isPaginaProtegida = !(paramAcao.equals("AbriFormLogin") || paramAcao.equals("EfetuaLogin"));
		// Checando login na sessao
		HttpSession sessao = request2.getSession();
		Boolean isUsuarioNaoLogado = (Usuario) sessao.getAttribute("usuarioLogado") == null ? true : false;
		if (isUsuarioNaoLogado && isPaginaProtegida) {
			response2.sendRedirect("entrada?acao=AbriFormLogin");
			return; //
		}

		System.out.println("Passando no Filtro: " + AutorizacaoFilter.class);
		// Continua requisicao
		chain.doFilter(request, response);

	}

}
