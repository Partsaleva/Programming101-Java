package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Agregator;

/**
 * Servlet implementation class News
 */
@WebServlet("/news")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Agregator agr=new Agregator();
    /**
     * Default constructor. 
     */
    public News() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setAttribute("news", agr.getRss("http://www.dnevnik.bg/rssc/?rubrid=1657"));
		request.getRequestDispatcher("/jsp/News.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
