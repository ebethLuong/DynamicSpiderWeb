package controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SpiderModel;

/**
 * Servlet implementation class AddTServlet
 */
@WebServlet("/addTServlet")
public class AddTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String species = request.getParameter("species");
		SpiderModel sp = new SpiderModel(name, species);
		SpiderHelper dao = new SpiderHelper();
		dao.insertSpider(sp);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
