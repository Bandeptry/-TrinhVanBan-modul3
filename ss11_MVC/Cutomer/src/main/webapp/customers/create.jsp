<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/12/2023
  Time: 05:12 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css"
          integrity="sha512-Ez0cGzNzHR1tYAv56860NLspgUGuQw16GiOOp/I2LuTmpSK9xDXlgJz3XN4cnpXWDmkNBKXR/VDMTCnAaEooxA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.min.js" integrity="sha512-EKWWs1ZcA2ZY9lbLISPz8aGR2+L7JVYqBAYTq5AXgBkSjRSuQEGqWx8R1zAX16KdXPaCjOCaKE8MCpU0wcHlHA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="container d-flex justify-content-center">
    <!-- justify-content-around: noi dung ra giua-->
    <div class="col-6 mt-3">
        <form action="" method="post">
            <h4>Create</h4>
            <div class="row mb-3 mt-3">
                <label class="col-3">Name: </label>
                <div class="col-9">
                    <input type="text" name="name" class="form-control">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Email: </label>
                <div class="col-9">
                    <input type="text" name="email" class="form-control">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Address: </label>
                <div class="col-9">
                    <input type="text" name="address" class="form-control">
                </div>
            </div>
            <div class="row ">
<%--                <label class="col-3" for=""></label>--%>
                <div class="col-9 offset-3">
                    <button class="btn btn-primary" type="submit">Create</button>
                    <button class="btn btn-dark" type="submit">Back</button>
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>
