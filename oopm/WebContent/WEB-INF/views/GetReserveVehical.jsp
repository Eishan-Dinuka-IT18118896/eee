<%@page import="model.ReserveVehical"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "ReserveVehical.css"/>
   
<meta charset="UTF-8">

<title>Reserve vehicle </title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<br> <br>
		
	<fieldset id = "field">
	<h2 class="h2"><span>Update and Delete Reservation </span></h2>

	<br> <br>
	
	<%
	ReserveVehical reserveVehical = (ReserveVehical) request.getAttribute("reserveVehical");
	%>

	<form method="post" action="UpdateReserVehicalServlet">
		   <table>
			<tr>
				<td>Reservation ID</td>
				<td><input type="text" name="reservationID" disabled="disabled" style="width:750px; height:30px;"
					value="<%=reserveVehical.getReservationID()%>"  /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="Name" style="width:750px; height:30px;"
					value="<%=reserveVehical.getName()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" style="width:750px; height:60px;"
					value="<%=reserveVehical.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Pick Up Location</td>
				<td><input type="text" name="pick_up_location" style="width:750px; height:30px;"
					value="<%=reserveVehical.getPick_up_location()%>" /></td>
			</tr>
			<tr>
				<td>Pick Up Date & Time</td>
				<td><input  type="datetime-local" name="pick_date_time" style="width:750px; height:30px;"
					value="<%=reserveVehical.getPick_date_time()%>" /></td>
			</tr>
			<tr>
				<td>Return Location</td>
				<td><input type="text" name="return_location" style="width:750px; height:30px;"
					value="<%=reserveVehical.getReturn_location()%>" /></td>
			</tr>
			<tr>
				<td>Return Date & Time</td>
				<td><input  type="datetime-local" name="return_date_and_time" style="width:750px; height:30px;"
					value="<%=reserveVehical.getReturn_date_and_time()%>" /></td>
			</tr>
			<tr>
				<td>No. Of Passengers</td>
				<td><input type="text" name="no_passenger" style="width:750px; height:30px;"
					value="<%=reserveVehical.getNo_passenger()%>" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="hidden" name="reservationID" 
					value="<%=reserveVehical.getReservationID()%>" /> <input type="submit"
					value="Update Vehicle Reservation" class="update-button"/></td>
			</tr>

	  </form>
	
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteReserVehicalServlet">
					<input type="hidden" name="reservationID"  
						value="<%=reserveVehical.getReservationID()%>" /> <input type="submit" 
						value="Delete Vehicle Reservation" class="delete-button" />
				</form>
			</td>
		</tr>
	</table>
    	<br><br><br><br><br>
		</fieldset>
		<br><br><br><br><br><br>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>