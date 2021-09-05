<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <th>Telugu</th>
                <th>Hindi</th>
                <th>English</th>
                <th>Maths</th>
            </tr>

<c:forEach items="${marks}" var="item">
<tr>
 <td>${marks}</td>
<td>${marks}</td>
<td>${marks}</td>
<td>${marks}</td>


    </tr>
</c:forEach>

        </table>
    </div>
     <h3>    You have no data in database</h3>
     <h3>    Contact your Admin :)</h3>

     <form action="studentProfile-0" method="POST">
         </form>

        <form action="studentProfile-${id}" method="POST">
              <div class="container">
                <button type="submit" > Student Prodile </button>
              </div>
         </form>

         <form action="/" method="POST">
                 <div class="container">
                   <button type="submit" class="cancelbtn"> Log-out </button>
                 </div>
         </form>

            </table><BR>
            </fieldset>
        </td></tr></table>
    </td></tr>
</table>


</table>
</body>
</html>