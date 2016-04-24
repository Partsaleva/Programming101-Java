package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Agregator;

/**
 * Servlet implementation class Sport
 */
@WebServlet("/sport")
public class Sport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Agregator agr=new Agregator();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		request.setAttribute("sport", agr.getRss("http://www.sportal.bg/uploads/rss_category_0.xml"));
		request.getRequestDispatcher("/jsp/Sport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
