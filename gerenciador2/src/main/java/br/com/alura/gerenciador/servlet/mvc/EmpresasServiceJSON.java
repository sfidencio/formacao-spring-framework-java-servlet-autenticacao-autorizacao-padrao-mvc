package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

/**
 * Servlet implementation class EmpresasService
 * Primeiro servico.
 * 
 * https://www.json.org/json-en.html
 */
@WebServlet("/empresas-json")
public class EmpresasServiceJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Empresa> lista = new Persistencia().obterTodasEmpresas();
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}

}
