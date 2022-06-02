import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

/*
 *https://hc.apache.org/httpcomponents-client-5.1.x/ 
 *
 */
public class ConsumoServicoWeb {

	public static void main(String[] args) {
		try {
//			String resultXml = Request.Post("http://localhost:8080/gerenciador2/empresas-xml")
//			.execute().returnContent().asString();
//			
//			System.out.println(resultXml);
//			
//			
//			System.out.println();
//			System.out.println();
//			
//			String resultJson = Request
//					.Post("http://localhost:8080/gerenciador2/empresas-json")
//					.addHeader("accept","application/json")
//					.execute()
//					.returnContent()
//					.asString();
//			
//			System.out.println(resultJson);

			String tipoRetorno1 = "application/xml";
			String tipoRetorno2 = "application/json";
			String tipoRetorno3 = "aapplication/text"; //invalido
			String tipoRetorno4 = "text/html"; //invalido
			
			String resultGererico = Request
					.Post("http://localhost:8080/gerenciador2/empresas-json-xml-xhtml")
					.addHeader("accept",tipoRetorno4)
					.execute()
					.returnContent()
					.asString();

			System.out.println(resultGererico);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
