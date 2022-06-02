package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.mvc.acao.Acao;

/**
 * Servlet implementation class ControladorUnificado
 */
//@WebServlet("/entrada")
//@WebServlet(urlPatterns = { "/entrada", "/entrada2" })
public class ControladorUnificadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControladorUnificadoServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
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
			url = ((Acao) obj).executar(request, response);

			// Codigo procedural comentado.. substituindo pelo codigo mais limpo
			/*
			 * if (paramAcao.equals("ListaEmpresas")) { acao = new ListaEmpresasImp(); url =
			 * acao.executar(request, response); System.out.println("Listando empresa"); }
			 * else if (paramAcao.equals("ListaEmpresasOrdenado")) { acao = new
			 * ListaEmpresasOrdenadoImp(); url = acao.executar(request, response);
			 * System.out.println("Listando empresa ordenada"); } else if
			 * (paramAcao.equals("ExcluiEmpresa")) { acao = new ExcluiEmpresaImp(); url =
			 * acao.executar(request, response); System.out.println("Excluir empresa"); }
			 * else if (paramAcao.equals("AlteraEmpresa")) { acao = new AlteraEmpresaImp();
			 * url = acao.executar(request, response); System.out.println("Altera empresa");
			 * } else if (paramAcao.equals("MostraEmpresa")) { acao = new
			 * MostraEmpresaImp(); url = acao.executar(request, response);
			 * System.out.println("Mostra empresa"); } else if
			 * (paramAcao.equals("NovaEmpresa")) { acao = new NovaEmpresaImp(); url =
			 * acao.executar(request, response); System.out.println("Nova empresa"); } else
			 * if (paramAcao.equals("NovoFormEmpresa")) { acao = new NovoFormEmpresaImp();
			 * url = acao.executar(request, response);
			 * System.out.println("Novo Form empresa"); }
			 */

			String[] arryClientOrServer = url.split(":");

			if (arryClientOrServer[0].trim().equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views" + arryClientOrServer[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(arryClientOrServer[1]);
			}

		} catch (ClassNotFoundException | InstantiationException | IOException | ParseException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
