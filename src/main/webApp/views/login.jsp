<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/login.css" media="screen" />
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


    <p class="tip">Student Management System</p>

    <div class="cont">
      <div class="form sign-in">
      <form action="" th:object ="${login}" method="POST">
        <h2>Welcome back,</h2>
        <label>
          <span>UserName</span>
          <input type="text" name="userName" required/>
        </label>
        <label>
          <span>Password</span>
          <input type="password" name="password" required/>
        </label>
       <%-- <p class="forgot-pass">Forgot password?</p> --%>
        <button type="submit" onclick="existsLogin(${existsLogin})" class="submit">Sign In</button>

      </form>


            <div class="unauthenticated">
                 <button type="submit" class="fb-btn">Connect with <a href="/facebook">facebook</a></button>
            </div>

            <br>

            <div class="authenticated">
                 <button type="submit" class="fb-btn"> Successfully logged into <span id="user">facebook</span></button>
            </div>
      </div>




      <div class="sub-cont">
        <div class="img">
          <div class="img__text m--up">
            <h2>New here?</h2>
            <p>Sign up and discover great amount of new opportunities!</p>
          </div>
          <div class="img__text m--in">
            <h2>One of us?</h2>
            <p>If you already has an account, just sign in. We've missed you!</p>
          </div>
          <div class="img__btn">
            <span class="m--up">Sign Up</span>
            <span class="m--in">Sign In</span>
          </div>

        </div>



        <div class="form sign-up">
         <form action="" th:object ="${student}" method="POST">
          <h2>Time to feel like home,</h2>
          <label>
            <span>User Name</span>
            <input type="text" name="userName" required/>
          </label>
          <label>
              <span>Email</span>
              <input type="email" name="email" required/>
          </label>
          <label>
            <span>Password</span>
            <input type="password" name="password" required/>
          </label>
          <label>
              <span>Re-enter Password</span>
              <input type="password" name="password2" required/>
          </label>

          <button type="submit" onclick="existsRegister(${existsRegister})" class="submit">Sign Up</button>

          </form>
          <form action="#">
                  <div class="authenticated">
                       <button type="submit" class="fb-btn">Join with <span id="user">facebook</span></button>
                  </div>
            </form>
        </div>
      </div>
    </div>
    <form action="/" method="POST">
               <button type="submit" class="submit">Cancel</button>
      </form>

    <%-- <a href="https://dribbble.com/shots/3306190-Login-Registration-form" target="_blank" class="icon-link">
      <img src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/256/Dribbble-icon.png">
    </a>
    <a href="https://twitter.com/NikolayTalanov" target="_blank" class="icon-link icon-link--twitter">
      <img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png">
    </a> --%>

<script src="js/login.js"></script>
</body>
</html>