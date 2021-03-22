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
 * Servlet implementation class GetReserVehicalServlet
 */
@WebServlet("/GetReserVehicalServlet")
public class GetReserVehicalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReserVehicalServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

 		String reservationID = request.getParameter("reservationID");	
 		IReserveService iReserveService = new ReserveVehicalImplemntation();
 		ReserveVehical reserveVehical = iReserveService.getReservationByID(reservationID);

		request.setAttribute("reserveVehical", reserveVehical);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetReserveVehical.jsp");
		dispatcher.forward(request, response);
	}

}
