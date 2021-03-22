<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>


<link rel = "stylesheet"
   type = "text/css"
   href = "ReserveVehical.css"/>
   
</head>

<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
  <h1>Login Page</h1>
  
 <button onclick="document.getElementById('id01').style.display='block'" style="width:100%;"><h1>Login</h1></button>
 <button style="display:inline-block">
  <img src="images/c3.png" style="float:left;margin-right:0.5em"> </button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="LoginServlet" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="images/ac1.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="uname"><b>User Name</b></label>
      <input type="text" placeholder="Enter Username" name="uid" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="pass" required>
        
     <input type="submit" class = "button1" name="submit" value ="login" style="width:100%; height:50px;">
      <label>
        <input type="checkbox" checked="checked"  name="submits"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <p class="psw">Forgot password?</p>
    </div>
  </form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>
