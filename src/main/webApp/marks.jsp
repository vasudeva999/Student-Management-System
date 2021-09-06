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
    <center> <h1> Student Marks Register Form </h1> </center>
    <form action="#" th:object ="${marks}" method="POST">
        <div class="container">
            <label>Student-ID : </label>
            <input type="text" placeholder="Enter Student ID" name="sid" value=${sid} required>
            <label>Telugu: </label>
            <input type="text" placeholder="Enter Telugu marks" name="teluguMarks" required>
            <label>Hindi : </label>
            <input type="text" placeholder="Enter Hindi marks" name="hindiMarks" required>
            <label>English : </label>
            <input type="text" placeholder="Enter English marks" name="englishMarks" required>
            <label>Maths : </label>
            <input type="text" placeholder="Enter Maths marks" name="mathsMarks" required>

        </div>
    </form>

    <form action="studentHome-${sid}" method="POST">
            <div class="container">
              <button type="submit"> Student Login</button>
            </div>
    </form>

    <form action="studentHome-${sid}" method="POST">
        <div class="container">
            <button type="submit" class="cancelbtn"> Cancel</button>
        </div>
    </form>

</body>
</html>