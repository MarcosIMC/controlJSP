package Servlet;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DataManager;

/**
 * Servlet implementation class MarcosControlServlet
 */
@WebServlet("/MarcosControlServlet")
public class MarcosControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataManager conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcosControlServlet() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String base = "/JSP/";
		String url = base + "Index.jsp";
		
		String peticion = request.getParameter("peticion");
		
		if(peticion != null) {
			switch (peticion) {
			case "ejercicio1":
				obtenerLink(request);
				url = base + "ejercicio1.jsp";
				break;
				
			case "ejercicio2":
				
				url = base + "ejercicio2.jsp";
				break;
				
			case "logueado":
				comprobarDatos();
				url = base + "logueado.jsp";
				break;
			}
		}
		System.out.println("URL "+url);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		ServletContext context = config.getServletContext();
		context.setAttribute("base", config.getInitParameter("base"));
		
		DataManager dataManager = new DataManager();
		dataManager.setDbURL(config.getInitParameter("dbURL"));
		dataManager.setDbUserName(config.getInitParameter("dbUserName"));
		dataManager.setDbPassword(config.getInitParameter("dbPassword"));
		conn = (DataManager) dataManager.getConnection();
		context.setAttribute("dataManager", dataManager);

		try { // load the database JDBC driver
			Class.forName(config.getInitParameter("jdbcDriver"));
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	

	private void obtenerLink(HttpServletRequest request) {
		String[] arrayLinks = new String[5];
		
		arrayLinks[0] = "http://www.google.com";
		arrayLinks[1] = "http://www.youtube.com";
		arrayLinks[2] = "http://www.amazon.com";
		arrayLinks[3] = "http://www.eurogamer.es";
		arrayLinks[4] = "http://www.marca.com";
		
		request.getSession().setAttribute("links", arrayLinks);
	}
	
	private void comprobarDatos() {
		if(conn !=null) {
			System.out.println("Existe conexion");
		}
	}
}
