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
@WebServlet("/empresas-json-xml-xhtml")
public class EmpresasServiceJSONEXMLEXHTML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valor = request.getHeader("accept");
		System.out.println(valor);

		if (valor.equals("application/json")) {
			List<Empresa> lista = new Persistencia().obterTodasEmpresas();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else if (valor.equals("application/xml")) {
			List<Empresa> lista = new Persistencia().obterTodasEmpresas();
			XStream xStream = new XStream();
			xStream.alias("Empresa", Empresa.class);
			String xml = xStream.toXML(lista);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else if (valor.contains("text/html")) {
			List<Empresa> lista = new Persistencia().obterTodasEmpresas();
			response.setContentType("text/html");
			response.getWriter().print("<html>");
			response.getWriter().print("<body>");
			response.getWriter().print("<lu>");
			lista.forEach(item -> {
				try {
					response.getWriter().print("<li>" + item.getCnpj() + "--" + item.getEmpresa() + "</li>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			response.getWriter().print("</lu>");

			response.getWriter().print("</body>");
			response.getWriter().print("</html>");
		} else {
			response.setContentType("application/text");
			response.getWriter().print("Tipo de retorno inválido.");
		}

	}

}
