<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel = "stylesheet"
   type = "text/css"
   href = "ReserveVehical.css"/>
   
<meta charset="ISO-8859-1">
<title>About Us </title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<br>

<div class="about-section">
  <h1>About Us </h1>
  <p>We are the number one Brand Giving Customers The Opportunity Of Traveling Around The Country</p>
  <p> Started since 2020 May with the Assocation of 4 people who graduated from the SLIIT . The small association of these people is the history Of Sri Lanka's transport sector being disrupted.</p>
</div>

<h2 style="text-align:center">Our Team</h2>
<div class="row">
  <div class="column">
    <div class="card">
      <img src="images/g11.png" alt="Jane" style="width:100%">
      <div class="container">
        <h2>Jayanga K and Liyanage K </h2>
        <p class="title">Accountants</p>
        <p>Some text that describes me.</p>
        <p>jaya@gamil.com</p>
        <p><button class="button"  onclick="window.location.href ='contact.jsp';">Contact</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="images/p1111.jpg" alt="Mike" style="width:100%">
      <div class="container">
        <h2>W.H.A.Eishan Dinuka</h2>
        <p class="title">CEO & Founder </p>
        <p>Some text that describes me.</p>
        <p>eishan2dinuka@gmail.com</p>
        <p><button class="button" onclick="window.location.href ='contact.jsp';">Contact</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <img src="images/g11.png"" alt="John" style="width:100%">
      <div class="container">
        <h2>Madhubashini</h2>
        <p class="title">Designer</p>
        <p>Some text that describes me.</p>
        <p>madu@gmail.com</p>
        <p><button class="button" onclick="window.location.href ='contact.jsp';">Contact</button></p>
      </div>
    </div>
  </div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>