
<%@page import="model.ReserveVehical"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.ReserveVehicalImplemntation"%>
<%@page import="service.IReserveService"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="ReserveVehical.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>list of Reservation</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<br>
	<br>
	<table border="1" cellpadding="10">
		<caption>
			<h1>
				<span>List of Reserve vehicle </span>
			</h1>
		</caption>
		<input class="reg1" type="button"
			onclick="window.location.href ='homeView.jsp';"
			value="Add New Reservation" />
		<tr class="listve">
			<th><center>Reservation ID</center></th>
			<th><center>Name</center></th>
			<th><center>Address</center></th>
			<th><center>Pick Up Location</center></th>
			<th><center>Pick Up Date & Time</center></th>
			<th><center>Return Location</center></th>
			<th><center>Return Date & Time</center></th>
			<th><center>No. Of Passengers</center></th>
			<th><center>Select</center></th>
		</tr>
		<%
			IReserveService iReserveService = new ReserveVehicalImplemntation();
		ArrayList<ReserveVehical> arrayList = iReserveService.getReserveVehical();

		for (ReserveVehical reserveVehical : arrayList) {
		%>
		<tr class="listve1">
			<td><%=reserveVehical.getReservationID()%></td>
			<td><%=reserveVehical.getName()%></td>
			<td><%=reserveVehical.getAddress()%></td>
			<td><%=reserveVehical.getPick_up_location()%></td>
			<td><%=reserveVehical.getPick_date_time()%></td>
			<td><%=reserveVehical.getReturn_location()%></td>
			<td><%=reserveVehical.getReturn_date_and_time()%></td>
			<td><%=reserveVehical.getNo_passenger()%></td>
			<td>
				<form method="POST" action="GetReserVehicalServlet">
					<input type="hidden" name="reservationID"
						value="<%=reserveVehical.getReservationID()%>" /> <input
						type="submit" value="Select Vehicle Reservation"
						class="select-button" />
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>