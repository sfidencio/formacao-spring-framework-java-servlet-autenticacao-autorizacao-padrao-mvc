package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.acao.Acao;

/**
 * Servlet implementation class ControladorUnificadoFilter
 * 
 * Trocamos o controlador Servlet por um Filter. Observe que comentamos a
 * annotation do Servelt..no arquivo ControladorUnificadoServlet.java
 * 
 * Esse tópico de filtros é fundamental e deve ser entendido conceitualmente, 
 * mesmo que você não vá utilizar Servlets diretamente (por exemplo, por estar usando uma biblioteca de mais alto nível). 
 * Isso porque o Spring MVC, o EJB e o VRaptor também têm filtros, mas que são chamados de interceptadores.
 */
//@WebFilter("/entrada")
public class ControladorUnificadoFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {

			HttpServletRequest request2 = (HttpServletRequest) request;
			HttpServletResponse response2 = (HttpServletResponse) response;

			String paramAcao = request.getParameter("acao");

//			Boolean isPaginaProtegida = !(paramAcao.equals("AbriFormLogin") || paramAcao.equals("EfetuaLogin"));
//			// Checando login na sessao
//			HttpSession sessao = request.getSession();
//			Boolean isUsuarioNaoLogado = (Usuario) sessao.getAttribute("usuarioLogado") == null ? true : false;
//			if (isUsuarioNaoLogado && isPaginaProtegida) {
//				response.sendRedirect("entrada?acao=AbriFormLogin");
//				return; //
//			}

			Acao acao = null;
			String url = null;

			/*
			 * https://cursos.alura.com.br/course/servlet-autenticacao-autorizacao-mvc/task/
			 * 45579 Importante fazer esses cursos de java sobre reflexão. - segue link
			 * acima.
			 */

			// ClassLoader utilizando reflection.
			String nomeClasse = "br.com.alura.gerenciador.servlet.mvc.acao." + paramAcao + "Imp";
			// https://stackoverflow.com/questions/46393863/what-to-use-instead-of-class-newinstance
			Class clazz = Class.forName(nomeClasse);
			// Acao acao = (Acao)classe.newInstance(); //Deprecated
			Object obj = clazz.getDeclaredConstructor().newInstance();
			url = ((Acao) obj).executar(request2, response2);

			String[] arryClientOrServer = url.split(":");

			if (arryClientOrServer[0].trim().equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views" + arryClientOrServer[1]);
				rd.forward(request, response);
			} else {
				response2.sendRedirect(arryClientOrServer[1]);
			}

			// Como e o ultimo filtro da cadeia, sequencial,.. primeiro vem AF, MF depois
			// CF...então esse nao faz chain.doFilter
			// chain.doFilter(request, response);

			System.out.println("Passando no Filtro: " + ControladorUnificadoFilter.class);

		} catch (ClassNotFoundException | InstantiationException | IOException | ParseException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
