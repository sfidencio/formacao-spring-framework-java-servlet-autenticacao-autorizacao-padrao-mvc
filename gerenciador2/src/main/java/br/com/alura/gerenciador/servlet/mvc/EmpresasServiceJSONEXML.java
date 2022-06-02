package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

/**
 * Servlet implementation class EmpresasService Primeiro servico.
 * 
 * https://www.json.org/json-en.html
 */
@WebServlet("/empresas-json-xml")
public class EmpresasServiceJSONEXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valor = request.getHeader("accept");

		if (valor.contains("json")) {
			List<Empresa> lista = new Persistencia().obterTodasEmpresas();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else if(valor.contains("xml")) {
			List<Empresa> lista = new Persistencia().obterTodasEmpresas();
			XStream xStream = new XStream();
			xStream.alias("Empresa", Empresa.class);
			String xml = xStream.toXML(lista);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}else {
			response.setContentType("application/text");
			response.getWriter().print("Tipo de retorno inválido.");
		}

	}

}
