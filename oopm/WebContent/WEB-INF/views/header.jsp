<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel = "stylesheet"
   type = "text/css"
   href = "ReserveVehical.css"/>
   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>

</head>
<body>
	
<table class ="new" border ="0" width ="100%" height ="100%">
<tr>
	
	<td width="15%" >
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div class ="logoimg">
		<img class = "logo" src="images/logo.png" width = "260px" height = "200px" style="margin-left:-20%;" alt="logo"> 
	</div>	
	</td>
	
	<td width="50%">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<a href="https://www.facebook.com"><img class = "fb" src="images/fb.png" width="60" height="60" alt="facebook"></a>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<a href="https://twitter.com"><img class = "tute" src="images/tute1.png" width="65" height="65" alt="twitter"></a>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<a href="https://www.instagram.com"><img class = "insta" src="images/instagram.png" width="60" height="60" alt="instagram"></a>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<a href="https://https://aboutme.google.com/u/0/?referer=gplus"><img class = "google" src="images/googleplus.png" width="60" height="60" alt="skype"></a>
	
	
	</td>
	
	
	<td width="25%">
	
     <form class="searchbox" action="/action_page.php" >
     <input type="text"  name="search2">
     <button type="submit"><i  class="search">Search </i></button>
     </form>
	
	</td>
	
	<td width="5%">

	<img class = "login" src="images/user.png" width="150" height="150" alt="login">	
</tr>
</table>

<ul class ="menu">
    <li class = "menu"><a href = "login.jsp" >Login </a> </li>
    <li class = "menu"><a href = "" > User Registration </a> </li>
	<li class = "menu"><a href = "index.jsp" >Home </a> </li>
	<li class = "menu"><a href = "homeView.jsp" >Reserve vehicle</a></li>
	<li class = "menu"><a href = ".jsp" >Add vehicle </a></li>
	<li class = "menu"><a href = "contact.jsp" >Contact us</a></li>
	<li class = "menu"><a href = "about_us.jsp" >About us</a></li>
</ul>


<div class ="slider">
  <div class="Images" style="max-width:200px">
  <img class="mySlides" src="images/s1.jpg" style="width:300%">
  <img class="mySlides" src="images/s2.jpg" style="width:300%">
  <img class="mySlides" src="images/s3.jpg" style="width:300%">
  <img class="mySlides" src="images/s4.jpg" style="width:300%">
  <img class="mySlides" src="images/s.jpg" style="width:300%">
 </div>
 </div>

<!------------------------- --------------------------------------------------------java script-------------------------------------------------------------------- -->
 <script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++)
  {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 4000); // Change image every 4 seconds
}
</script> 


</body>
</html>