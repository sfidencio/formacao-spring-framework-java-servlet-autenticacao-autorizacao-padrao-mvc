package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 * 
 * 
 * O filtro consegue parar a execução, já que ele vem como uma camada à frente da aplicação.
 * Alternativa correta! Essa é a diferença que podemos ver no nosso código,
 * através do parâmetro FilterChain. Usamos o FilterChain para mandar a
 * requisição para frente.
 */
//@WebFilter("/entrada")
public class MonitoramentoFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String acao = request.getParameter("acao");
		long inicioExecucao = System.currentTimeMillis(); // Pega hora em ms desde 1970
		// pass the request along the filter chain - diz pra aplicacao continuar
		// executando.. pra cada requisicao.
		chain.doFilter(request, response);
		long fimExecucao = System.currentTimeMillis();
		System.out.println("Tempo de Execução: " + (fimExecucao - inicioExecucao) + " para a acao: " + acao);
		System.out.println("Passando no Filtro: " + MonitoramentoFilter.class);
	}

}
