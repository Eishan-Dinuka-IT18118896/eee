package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReserveVehical;
import service.ReserveVehicalImplemntation;
import service.IReserveService;


/**
 * Servlet implementation class AddReserVehicalServlet
 */
@WebServlet("/AddReserVehicalServlet")
public class AddReserVehicalServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReserVehicalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");

		ReserveVehical reserveVehical = new ReserveVehical();
		
		reserveVehical.setName(request.getParameter("Name"));
		reserveVehical.setAddress(request.getParameter("address"));
		reserveVehical.setPick_up_location(request.getParameter("pick_up_location"));
		reserveVehical.setPick_date_time(request.getParameter("pick_date_time"));
		reserveVehical.setReturn_location(request.getParameter("return_location"));
		reserveVehical.setReturn_date_and_time(request.getParameter("return_date_and_time"));
		reserveVehical.setNo_passenger(request.getParameter("no_passenger"));

		IReserveService iReserveService = new ReserveVehicalImplemntation();
		iReserveService.addReserve(reserveVehical);

		request.setAttribute("reserveVehical", reserveVehical);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListReserveVehical.jsp");
		dispatcher.forward(request, response);
	}

}
