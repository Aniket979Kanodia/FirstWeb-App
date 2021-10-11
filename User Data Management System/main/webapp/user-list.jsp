<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage = "Error.jsp" %>   
<!DOCTYPE html>
<html>
<head>
    <style>
    body{
  margin: 0;
  padding: 0;
  background: linear-gradient(120deg,#2980b9, #8e44ad);
  height: 100vh;
  overflow: hidden;
}
        th, td {
        color: white;
      
      
        align-content: center;
        }
        table{
       
            margin-left: auto;
            margin-right: auto;
            align-content: center;
            border: groove;
        }
        table thead tr th {
    color: black;
    border: groove;
}

      input, button, select, textarea {
    font-family: inherit;
    font-size: inherit;
    line-height: inherit;
    border-radius: 10px;
    /* color: blue; */
    /* backface-visibility: hidden; */
    background-color: transparent;
}
tr{
line-height: 40px;
border: groove;
}
    </style>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>User List</title>
</head>
<body bgcolor="blue">
<header>
    <nav class="navbar navbar-findcond navbar-fixed-top" style="background-color:;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <p style="color: aliceblue; padding-top: 17px;font-size: 25px;">USER DATA</p>
            </div>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li >
                        <a href="Login.jsp" role="button" > Login </a>
                       
                    </li>
                    <li class="active"><a href="<%=request.getContextPath()%>/list">Users List<span class="sr-only">(current)</span></a></li>
                    <li>
                        <a href="UserRegistration.jsp">Add user</a>
                        
                    </li>
                </ul>
                <form class="navbar-form navbar-right search-form" role="search">
                    <input type="text" class="form-control" name = "fname" placeholder="First Name" /> 
              
                    <input type="text" class="form-control" name = "lname" placeholder="Last Name" /> <input type="submit" value ="Search">
                </form>
            </div>
        </div>
    </nav>
    </header>
    
    <br>
   
    <br>
       <hr>
    <br>
    <br>
    <br>
  
    <table style=" width: 90%;" >
        <thead>
            <tr class>
                <th >Party Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip</th>
                <th>Country</th>
                <th>Phone</th>
                <th>
                    User Id
                </th>
                <th>Password</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items= "${listUsers}">
                <tr " >
                    <td ><c:out value="${member.partyID}" /></td>
                    <td ><c:out value="${member.fnamen}" /></td>
                    <td><c:out value="${member.lnamen}" /></td>
                    <td><c:out value="${member.address}" /></td>
                    <td><c:out value="${member.city}" /></td>
                    <td><c:out value="${member.state}" /></td>
                    <td><c:out value="${member.zip}" /></td>
                    <td><c:out value="${member.country}" /></td>
                    <td><c:out value="${member.phone}" /></td>
                    <td><c:out value="${member.userID}" /></td>
                    <td><c:out value="${member.password}" /></td>
                    <td><a href="edit?partyID=<c:out value='${member.partyID}'/>">Edit</a> 
                        &nbsp;&nbsp;&nbsp;<a href="delete?partyID=<c:out value="${member.partyID}" />">Delete</a></td>

                </tr>
            </c:forEach>   
            

        </tbody>
    </table>
</body>
</html>