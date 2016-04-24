package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Agregator;

/**
 * Servlet implementation class Technology
 */
@WebServlet("/technology")
public class Technology extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Agregator agr=new Agregator();
    /**
     * Default constructor. 
     */
    public Technology() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setAttribute("technology", agr.getRss("(//www.kaldata.com/rosebud/rss.php?catid=3"));
		request.getRequestDispatcher("/jsp/Technology.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
