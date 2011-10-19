package br.com.comentesobre.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {

	private static final long serialVersionUID = 8177484244723182200L;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException{
		String caminho = servletConfig.getServletContext().getRealPath(System.getProperty("file.separator"));
		String nomeArquivo = servletConfig.getInitParameter("log4j-init-file");
		
		if(nomeArquivo != null) {
			PropertyConfigurator.configure(caminho + nomeArquivo);
		} else {
			BasicConfigurator.configure();
		}

		super.init(servletConfig);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	}
}
