package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutImp implements Acao {
/*Quando utilizamos o removeAtribute, 
 *nosso objeto HttpSession ainda continua em memória (o cookie também continua lá). 
 *Já quando usamos o invalidate, ele remove o objeto HttpSession, 
 *todos os objetos associados e também remove o cookie!
 */
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		HttpSession sessao = request.getSession();
		//sessao.removeAttribute("usuarioLogado");
		sessao.invalidate(); //Invalida sessao, destruindo-a, todos objetos colocados nela.
		return "redirect:entrada?acao=AbriFormLogin";
	}

}
