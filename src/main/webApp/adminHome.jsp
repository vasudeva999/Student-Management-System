<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<html xmlns=""><head>
<title> home </title>
<style>
Body {
  font-family: Calibri, Helvetica, sans-serif;
  background-color: pink;
}
button {
       background-color: #4CAF50;
       width: 100%;
        color: orange;
        padding: 15px;
        margin: 10px 0px;
        border: none;
        cursor: pointer;
         }
 form {
        border: 3px solid #f1f1f1;
    }
 input[type=text], input[type=password] {
        width: 100%;
        margin: 8px 0;
        padding: 12px 20px;
        display: inline-block;
        border: 2px solid green;
        box-sizing: border-box;
    }
 button:hover {
        opacity: 0.7;
    }
  .cancelbtn {
        width: auto;
        padding: 10px 18px;
        margin: 10px 5px;
    }


 .container {
        padding: 25px;
        background-color: lightblue;
    }
    .submitButton {
                 display: inline-block;
                 padding: 10px 20px;
                 text-align: center;
                 text-decoration: none;
                 color: #ffffff;
                 background-color: #7aa8b7;
                 border-radius: 6px;
                 outline: none;
                 margin-top: 19px;
               }
</style>
</head>
<body>


<table width="780" align=center cellspacing=0 border="4" cellpadding=0>



    <tr><td>
        <table width="600" height="300"align=center cellspacing=0 border="0" cellpadding=0>
        <tr><td>
            <fieldset id="fieldhead">
            <legend> Welcome to Student Portal </legend><BR>
            <table align=center cellspacing=1 cellpadding=3><form method=get action="">
                <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Marks Sheet</h2></caption>
           <tr>

                <th>Student Id</th>
                <th>Telugu</th>
                <th>Hindi</th>
                <th>English</th>
                <th>Maths</th>
                <th>Total Marks</th>

            </tr>


<c:forEach items="${allStudents}" var="student">
<tr>
<td>${student.id}</td>
 <td>${student.telugu}</td>
<td>${student.hindi}</td>
<td>${student.english}</td>
<td>${student.maths}</td>
<td>${student.total}</td>


    </tr>
</c:forEach>

        </table>
    </div>
            <a class="submitButton" href="updateMarkList-${id}"> Update Marks </a>
            <a class="submitButton" href="createMarkList-${id}"> Create Mark List </a>
            <a class="submitButton" href="profile-${id}"> Profile </a>

            <a class="submitButton" href="studentHome-${id}"> Switch to Student Home Page </a>
            <a class="submitButton" href="/"> Log-out </a>

            </table><BR>
            </fieldset>
        </td></tr></table>
    </td></tr>
</table>


</body>
</html>