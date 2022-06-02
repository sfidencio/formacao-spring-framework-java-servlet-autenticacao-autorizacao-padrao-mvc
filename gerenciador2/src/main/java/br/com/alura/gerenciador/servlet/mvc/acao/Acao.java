package br.com.alura.gerenciador.servlet.mvc.acao;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException;
}
