<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel = "stylesheet"
   type = "text/css"
   href = "ReserveVehical.css" />

<meta charset="ISO-8859-1">
<title>ReserveVehical</title>
</head>



<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<br>
	
       <fieldset id = "field">
    <center>
	<h1 class="h2"><span> Add Reservation </span></h1>
	</center>
	<br>
	<br>
	

	<form method="POST" action="AddReserVehicalServlet">
		<table>

			<tr>
				<td>Name</td>			
				<td><input type="text" name="Name" style="width:750px; height:30px;" /></td>						
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"style="width:750px; height:60px;" /></td>
			</tr>
			<tr>
				<td>Pick Up Location</td>
				<td><input type="text" name="pick_up_location"style="width:750px; height:30px;" /></td>
			</tr>
			<tr>
				<td>Pick Up Date & Time</td>
				<td><input  type="datetime-local" name="pick_date_time" style="width:750px; height:30px;"/></td>
			</tr>
			<tr>
				<td>Return Location</td>
				<td><input type="text" name="return_location"style="width:750px; height:30px;" /></td>
			</tr>
			<tr>
				<td>Return Date & Time</td>
				<td><input type="datetime-local" name="return_date_and_time"style="width:750px; height:30px;" /></td>
			</tr>
			<tr>
				<td>No.Of Passengers</td>
				<td><input type="text" name="no_passenger" style="width:750px; height:30px;"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add New Vehicle Reservation" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="Reset" value="Reset the Details" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="ListReserVehicalServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="All Reservation Details" class="list-button" style="width:900px; height:40px;" />
				</td>
			</tr>
		</table>
	</form>
	<br><br><br><br><br>
		</fieldset>
		<br><br><br><br><br><br>
		
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>