package br.com.alura.gerenciador.servlet.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.servlet.mvc.model.Empresa;

/**
 * Servlet implementation class EmpresasService Primeiro servico.
 * 
 * https://www.json.org/json-en.html
 */
@WebServlet("/empresas-xml")
public class EmpresasServiceXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Empresa> lista = new Persistencia().obterTodasEmpresas();
		XStream xStream = new XStream();
		xStream.alias("Empresa",Empresa.class);	
		String xml = xStream.toXML(lista);
		response.setContentType("application/xml");
		response.getWriter().print(xml);

	}

}
