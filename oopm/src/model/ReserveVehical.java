package model;

public class ReserveVehical {
	
	private String ReservationID;
	
	private String Name;

	private String Address;

	private String pick_up_location;

	private String pick_date_time;

	private String Return_location;
	
	private String Return_date_and_time;
	
	private String No_passenger;
	
	public String getReservationID() {
		return ReservationID;
	}

	public void setReservationID(String reservationID) {
		ReservationID = reservationID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPick_up_location() {
		return pick_up_location;
	}

	public void setPick_up_location(String pick_up_location) {
		this.pick_up_location = pick_up_location;
	}

	public String getPick_date_time() {
		return pick_date_time;
	}

	public void setPick_date_time(String pick_date_time) {
		this.pick_date_time = pick_date_time;
	}

	public String getReturn_location() {
		return Return_location;
	}

	public void setReturn_location(String return_location) {
		Return_location = return_location;
	}

	public String getReturn_date_and_time() {
		return Return_date_and_time;
	}

	public void setReturn_date_and_time(String return_date_and_time) {
		Return_date_and_time = return_date_and_time;
	}

	public String getNo_passenger() {
		return No_passenger;
	}

	public void setNo_passenger(String no_passenger) {
		No_passenger = no_passenger;
	}

	@Override
	public String toString() {
		
		return "Reservation ID= " + ReservationID + "\n" + "Name = " + Name + "\n" + "Address = " + Address + "\n"
				+ "pick up location = " + pick_up_location + "\n" + "pick date time = " + pick_date_time + "\n" + "Return location = "
				+ Return_location + "\n" + "Return date and time = " + Return_date_and_time + "\n" + "No passenger = " + No_passenger;
	}

}
