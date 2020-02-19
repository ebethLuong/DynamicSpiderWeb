package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SpiderModel;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToItem");
		SpiderHelper dao = new SpiderHelper();
		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllTsServlet";
		if (act.equals("delete")) 
		{
			try
			{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			SpiderModel spiderToDelete = dao.searchById(tempId);
			dao.deleteSpider(spiderToDelete);
			}
			catch(Exception e)
			{
				System.out.println("Forgot to select an item");	
			}
		} 
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				SpiderModel spiderToEdit = dao.searchById(tempId);

				request.setAttribute("spiderToEdit", spiderToEdit);
				path = "/editSpider.jsp";
				} catch (Exception e) {
				System.out.println("Forgot to select an item");
				}
		} 
		else if (act.equals("add")) {
			
			try
			{
			SpiderModel sp = new SpiderModel("", "");
			dao.insertSpider(sp);
			SpiderModel spiderToEdit = dao.searchById(sp.getId());
			request.setAttribute("spiderToEdit", spiderToEdit);
			path = "/editSpider.jsp";
			}
			catch (Exception e)
			{
				
			}
			//create a new spider
			//dao.insert spider
			//get spider ID
			//set spider 

			//edit spider jsp
		//path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
