<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Login Page </title>
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
    <center> <h1> Student Marks Management System </h1> </center>

    <form action="login" method="POST">
            <div class="container">
              <button type="submit"> Admin Login </button>
            </div>
    </form>

    <form action="register" method="POST">
        <div class="container">
          <button type="submit"> New Register</button>
        </div>
    </form>

    <form action="login" method="POST">
            <div class="container">
              <button type="submit"> Login </button>
            </div>
    </form>

    <form action="studentHome-0" method="POST">
            <div class="container">
                <button type="submit" > Go to Student Home Page </button>
            </div>
    </form>

    <form action="profile-0" method="POST">
            <div class="container">
                <button type="submit" > Go to Student Profile Page </button>
            </div>
    </form>

</body>
</html>