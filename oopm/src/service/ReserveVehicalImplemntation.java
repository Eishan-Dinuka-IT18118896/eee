package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import model.ReserveVehical;
import util.CommonConstants;
import util.CommonUtil;
import util.DBConnectionUtil;
import util.QueryUtil;


/**  Contract for the implementation of reservation Service .*/
	

public class ReserveVehicalImplemntation implements IReserveService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ReserveVehicalImplemntation.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		ReserveVehicalTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing reservations table in the database and
	 * recreate table structure to insert reservation entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */	
	
	public static void ReserveVehicalTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new reservations table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Add set of ReserveVehical for as a batch from the selected ReserveVehical List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addReserve(ReserveVehical reserveVehical) {

		String reservationID = CommonUtil.generateIDs(getReservationIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in ReserveVehicalQuery.xml file and use
			 * insert_ReserveVehical key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_RESERVEVEHICAL));
			connection.setAutoCommit(false);
			
			//Generate Reservation IDs
			
			reserveVehical.setReservationID(reservationID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reserveVehical.getReservationID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, reserveVehical.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, reserveVehical.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, reserveVehical.getPick_up_location());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, reserveVehical.getPick_date_time());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, reserveVehical.getReturn_location());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, reserveVehical.getReturn_date_and_time());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, reserveVehical.getNo_passenger());
			
			// Add ReserveVehical
			
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * ReserveVehical details can be retrieved based on the provided Reservation ID
	 * 
	 * @param ReservationID
	 *            - ReserveVehical details are filtered based on the ID
	 * 
	 * @see #actionOnReserveVehical()
	 */
	
	@Override
	public ReserveVehical getReservationByID(String reservationID) {

		return actionOnReserveVehical(reservationID).get(0);
	}
	
	/**
	 * Get all list of reservations
	 * 
	 * @return ArrayList<reservation> 
	 * 						- Array of reservation list will be return
	 * 
	 * @see #actionOnReserveVehical()
	 */
	@Override
	public  ArrayList<ReserveVehical> getReserveVehical(){
		
		return actionOnReserveVehical(null);
	}

	/**
	 * This method delete an ReserveVehical based on the provided ID
	 * 
	 * @param ReservationID
	 *            - Delete ReserveVehical according to the filtered ReserveVehical details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeReserveVehical(String reservationID) {

		// Before deleting check whether Reservation ID is available
		if (reservationID != null && !reservationID.isEmpty()) {
			/*
			 * Remove reservation query will be retrieved from ReserveVehicalQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_RESERVEVEHICAL));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reservationID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET reservation by ID and Display all ReserveVehical
	 * 
	 * @param reservationID
	 *            ID of the ReserveVehical to remove or select from the list

	 * @return ArrayList<ReserveVehical> Array of ReserveVehical list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getreservations()
	 * @see #getreservationByID(String)
	 */
	
	private ArrayList<ReserveVehical> actionOnReserveVehical(String reservationID)
	{
		
		ArrayList<ReserveVehical> ReserveVehicalList = new ArrayList<ReserveVehical>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching reservation it checks whether  reservation ID is
			 * available
			 */
			if (reservationID != null && !reservationID.isEmpty()) {
				/*
				 * Get Reservation by ID query will be retrieved from
				 * ReservehicleQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_RESERVEVEHICAL));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reservationID);
			}
			/*
			 * If reservation ID is not provided for get reservation option it display
			 * all Reservation
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_RESERVEVEHICAL));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReserveVehical reserveVehical = new ReserveVehical();
				reserveVehical.setReservationID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				reserveVehical.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				reserveVehical.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				reserveVehical.setPick_up_location(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				reserveVehical.setPick_date_time(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				reserveVehical.setReturn_location(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				reserveVehical.setReturn_date_and_time(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				reserveVehical.setNo_passenger(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				ReserveVehicalList.add(reserveVehical);
				
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return ReserveVehicalList;
	}

	/**
	 * Get the update ReserveVehical
	 * 
	 * @param reservationID
	 *            ID of the Reservation to remove or select from the list
	 * 
	 * @return return the ReserveVehical object
	 * 
	 */
	@Override
	public ReserveVehical updateReserveVehical(String reservationID, ReserveVehical reserveVehical) {

		/*
		 * Before fetching ReserveVehical it checks whether reservation ID is available
		 */
		if (reservationID != null && !reservationID.isEmpty())
		{
			 /*
			 * Update ReserveVehical query will be retrieved from ReserveVehicalQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_RESERVEVEHICAL));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, reserveVehical.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, reserveVehical.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, reserveVehical.getPick_up_location());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, reserveVehical.getPick_date_time());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, reserveVehical.getReturn_location());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, reserveVehical.getReturn_date_and_time());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, reserveVehical.getNo_passenger());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, reserveVehical.getReservationID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) 
					{
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated reserveVehicle
		
		return getReservationByID(reservationID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of reserveVehical id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	
	private ArrayList<String> getReservationIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of reservation IDs will be retrieved from ReserveVehicalQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_RESERVEVEHICALS_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
