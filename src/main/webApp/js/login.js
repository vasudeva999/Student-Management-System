document.querySelector('.img__btn').addEventListener('click', function() {
  document.querySelector('.cont').classList.toggle('s--signup');
});

function existsLogin(val) {
  if (val!="") {alert("UserName or Password is wrong.\nSign-up for new Account.");}
}

function existsRegister(val) {
  if (val!="") {alert("User Already Exists.\nTry to Logging in...");}
}
$.get("/user", function(data) {
        $("#user").html(data.userAuthentication.details.name);
        $(".unauthenticated").hide()
        $(".authenticated").show()
    });