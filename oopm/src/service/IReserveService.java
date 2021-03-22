package service;

import model.ReserveVehical;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


public interface IReserveService {
	

	/** Initialize logger */
	
	public static final Logger log = Logger.getLogger(IReserveService.class.getName());


	/**
	 * Add Reserve for Reserve table
	 * @param ReserveVehical
	 */
	public void addReserve(ReserveVehical reserveVehical);

	/**
	 * Get a particular Reservation
	 * 
	 * @param ReservationID
	 * @return ReserveVehical
	 */
	public ReserveVehical getReservationByID(String reservationID);
	
	/**
	 * Get all list of ReserveVehical
	 * 
	 * @return ArrayList<ReserveVehical>
	 */
	public ArrayList<ReserveVehical> getReserveVehical();
	
	/**
	 * Update existing ReserveVehical
	 * @param ReservationID
	 * @param ReserveVehical
	 * 
	 * @return
	 */
	public ReserveVehical updateReserveVehical(String reservationID, ReserveVehical reserveVehical);

	/**
	 * Remove existing reserveVehical
	 * 
	 * @param ReservationID
	 */
	public void removeReserveVehical(String reservationID);



}

