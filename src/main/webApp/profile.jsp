<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> Student Profile </title>
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
       }
</style>
</head>
<body>
<center> <h1> Student Profile </h1> </center>

<form action="#" th:object ="${student}" method="POST">
    <div class="container">
        <label>UserName : </label>
        <input type="text" value="${student.getUserName()}" readonly>
        <label>FirstName : </label>
        <input type="text" value="${student.getFirstName()}" readonly>
        <label>LastName : </label>
        <input type="text" value="${student.getLastName()}" readonly>
        <label>Email-ID : </label>
        <input type="text" value="${student.getEmail()}" readonly>
        <label>Password : </label>
        <input type="password" value="Password is Hidden" readonly>

        <a class="submitButton" href="updateStudent-${student.getId()}"> Update Details </a>
        <a class="submitButton" href="studentHome-${student.getId()}"> Cancel </a>

    </div>
</form>


</body>
</html>