<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructXpert</title>
    <link rel="shortcut icon" href="assets/logo-head.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <style><%@include file="css/style.css"%></style>

</head>
<body>
<section class="authentication container d-flex justify-content-between">
    <div class="left d-flex flex-column justify-content-between">
        <div class="icon">
            <img src="assets/back.png" alt="error">
        </div>
        <div class="bg">
            <img src="assets/auth-bg.png" alt="error">
        </div>
    </div>
    <div class="right">
        <div class="logo">
            <img src="assets/logo-white.png" alt="">
        </div>
        <div class="welcome">
            <h1>welcome back,</h1>
            <span>Welcome back! Please enter your details.</span>
            <form action="auth"  method="POST">
                <div class="form-group">
                    <input type="text" class="input" id="username" name="username" placeholder="Username" required>
                </div>
                <div class="form-group">
                    <input type="password" class="input control" id="password" name="password" placeholder="Password" oninput="handleChange()" required>
                    <button class="password-button" type="button" id="passwordButton" onclick="togglePassword(event)">
                                <span id="passwordIcon" class="material-symbols-outlined">
                                    visibility
                                    </span>
                    </button>
                </div>
                <div class="strenght d-flex flex-row justify-content-between">
                    <div id="bars">
                        <div></div>
                    </div>
                    <div class="strenghty"  id="strenght"></div>
                </div>
                <div class="form-group">
                    <div class="Terms-password d-flex flex-row justify-content-between">
                        <div class="terms d-flex flex-row align-content-center align-items-center">
                            <input type="checkbox">
                            <span>Terms & conditions</span>
                        </div>
                        <div class="forgot">
                            <a href="">Forgot your password</a>
                        </div>
                    </div>
                </div>
                <div class="button">
                    <button type="submit" class="btn">Login</button>
                </div>
            </form>
        </div>
        <div class="authenticate">
            <div class=" d-flex flex-row justify-content-evenly">
                <div class="terms">
                    <p>Don't have an account?</p>
                </div>
                <div class="forgot">
                    <a href="">Sign up for free</a>
                </div>
            </div>
        </div>
    </div>
</section>
<script><%@include file="js/script.js"%></script>
</body>
</html>