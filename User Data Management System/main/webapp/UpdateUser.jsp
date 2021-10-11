<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage = "Error.jsp" %>  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Update</title>
 <style>
   @import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&family=Poppins:wght@400;500;600&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body{
  margin: 0;
  padding: 0;
  background: linear-gradient(120deg,#2980b9, #8e44ad);
  height: 100vh;
  overflow: hidden;
}
.center{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 400px;
  background: white;
  border-radius: 10px;
  box-shadow: 10px 10px 15px rgba(0,0,0,0.05);
}
.center h1{
  text-align: center;
  padding: 20px 0;
  border-bottom: 1px solid silver;
}
.center form{
  padding: 0 40px;
  box-sizing: border-box;
}
form .txt_field{
  position: relative;
  border-bottom: 2px solid #adadad;
  margin: 20px 0;
}
.txt_field input{
  width: 80%;
  padding: 0 5px;
  height: 30px;
  font-size: 16px;
  border: none;
  background: none;
  outline: none;
}
.txt_field label{
  position: absolute;
  top: 50%;
  left: 5px;
  color: #adadad;
  transform: translateY(-50%);
  font-size: 16px;
  pointer-events: none;
  transition: .5s;
}
.txt_field span::before{
  content: '';
  position: absolute;
  top: 30px;
  left: 0;
  width: 0%;
  height: 2px;
  background: #2691d9;
  transition: .5s;
}
.txt_field input:focus ~ label,
.txt_field input:valid ~ label{
  top: -5px;
  color: #2691d9;
}
.txt_field input:focus ~ span::before,
.txt_field input:valid ~ span::before{
  width: 100%;
}
.pass{
  margin: -5px 0 20px 5px;
  color: #a6a6a6;
  cursor: pointer;
}
.pass:hover{
  text-decoration: underline;
}
input[type="submit"]{
  width: 100%;
  height: 50px;
  border: 1px solid;
  background: #2691d9;
  border-radius: 25px;
  font-size: 18px;
  color: #e9f4fb;
  font-weight: 700;
  cursor: pointer;
  outline: none;
}
input[type="submit"]:hover{
  border-color: #2691d9;
  transition: .5s;
}
.signup_link{
  margin: 30px 0;
  text-align: center;
  font-size: 16px;
  color: #666666;
}
.signup_link a{
  color: #2691d9;
  text-decoration: none;
}
.signup_link a:hover{
  text-decoration: underline;
}
   
   </style>
</head>
<body>


<div class = "center">
<h1>Update User</h1>
<form action="Update" method = "post">



<div class="txt_field">
          <input type="text" name ="partyID" value=<c:out value="${member.partyID}" /> required>
          <span></span>
          <label>Party ID</label>
        </div>

<div class="txt_field">
          <input type="text" name="userID" value=<c:out value="${member.userID}" /> required>
          <span></span>
          <label>UserID</label>
        </div>

<div class="txt_field">
          <input type="password" name ="password" value=<c:out value="${member.password}" /> required>
          <span></span>
          <label>Password</label>
        </div>

<div class="txt_field">
          <input type="text" name ="fname" value=<c:out value="${member.fnamen}" />>
          <span></span>
          <label>First Name</label>
        </div>

<div class="txt_field">
          
          <input type="text" name ="lname" value=<c:out value="${member.lnamen}" />>
          <span></span>
          <label>Last Name</label>
        </div>

<div class="txt_field">
          <input type="text" name ="address" value=<c:out value="${member.address}" />>
          <span></span>
          <label>Address</label>
        </div>

<div class="txt_field">
          <input type="text" name ="city" value=<c:out value="${member.city}" /> >
          <span></span>
          <label>City</label>
        </div>

<div class="txt_field">
          <input type="text" name ="state" value=<c:out value="${member.state}" /> >
          <span></span>
          <label>State</label>
        </div>

<div class="txt_field">
         <input type="text" name ="zip" value=<c:out value="${member.zip}" /> >
          <span></span>
          <label>Zip</label>
        </div>

<div class="txt_field">
          <input type="text" name ="country" value=<c:out value="${member.country}" /> >
          <span></span>
          <label>Country</label>
        </div>

<div class="txt_field">
          <input type="text" name ="phone" value=<c:out value="${member.phone}" /> >
          <span></span>
          <label>Phone</label>
        </div>
<input type="Submit" name ="Register" value = "Update">


</form>

</div>
</body>
</html>