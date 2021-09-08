<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Register Page </title>
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
</style>
</head>
<body>
    <center> <h1> Student Register Form </h1> </center>
    <form action="#" th:object ="${student}" method="POST">
        <div class="container">
            <h4>${exists}</h4>
            <label>UserName : </label>
            <input type="text" placeholder="Enter UserName" name="userName" required>
            <label>FirstName : </label>
            <input type="text" placeholder="Enter FirstName" name="firstName" required>
            <label>LastName : </label>
            <input type="text" placeholder="Enter LastName" name="lastName" required>
            <label>EmailID : </label>
            <input type="text" placeholder="Enter Email-ID" name="email" required>
            <label>Password : </label>
            <input type="password" placeholder="Enter your Password" name="password" required>
            <label>Re-type Password : </label>
            <input type="password" placeholder="Re-type your Password" name="password2" required>
            <input type="checkbox" name="admin"> Make Admin

            <button type="submit">Register</button>

        </div>
    </form>

    <form action="login" method="POST">
            <div class="container">
              <button type="submit"> Login </button>
            </div>
    </form>

    <form action="/" method="POST">
        <div class="container">
            <button type="submit" class="cancelbtn"> Cancel</button>
        </div>
    </form>

</body>
</html>