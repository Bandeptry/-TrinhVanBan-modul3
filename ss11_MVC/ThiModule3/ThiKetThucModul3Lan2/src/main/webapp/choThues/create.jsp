<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20/12/2023
  Time: 07:26 p.m.
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.10.1/sweetalert2.css" integrity="sha512-pxzljms2XK/DmQU3S58LhGyvttZBPNSw1/zoVZiYmYBvjDQW+0K7/DVzWHNz/LeiDs+uiPMtfQpgDeETwqL+1Q=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.10.1/sweetalert2.min.js" integrity="sha512-lhtxV2wFeGInLAF3yN3WN/2wobmk+HuoWjyr3xgft42IY0xv4YN7Ao8VnYOwEjJH1F7I+fadwFQkVcZ6ege6kA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="container d-flex justify-content-center">
    <!-- justify-content-around: noi dung ra giua-->
    <div class="col-6 mt-3">
        <form method="post" action="">
            <h4>Create</h4>
            <%--                        <c:if test="${requestScope.message != null}">--%>
            <%--                            <div class="alert alert-danger">--%>
            <%--                                <label>${requestScope.message}</label>--%>
            <%--                            </div>--%>
            <%--                        </c:if>--%>
            <c:if test="${requestScope.message != null}">
                <script>
                    window.onload = ()=>
                    {
                        Swal.fire({
                            position: "top-end",
                            icon: "success",
                            title: "${requestScope.message}",
                            showConfirmButton: false,
                            timer: 1500
                        });
                    }
                </script>
            </c:if>
            <div class="row mb-3 mt-3">
                <label class="col-3">Dien Tich: </label>
                <div class="col-9">
                    <input type="text" name="a" class="form-control">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Trang Thai: </label>
                <div class="col-9">
                    <select name="b" class="form-select" aria-label="Default select example">
                        <option>Chọn Trang Thai </option>
                        <c:forEach items="${trangThais}" var="c1">
                            <option value="${c1.getIdTrangThai()}">${c1.getNameTrangThai()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mb-3 mt-3">
                <label class="col-3">tang: </label>
                <div class="col-9">
                    <input type="text" name="c" class="form-control">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Loai van phong: </label>
                <div class="col-9">
                    <select name="d" class="form-select" aria-label="Default select example">
                        <option>Chọn Loai </option>
                        <c:forEach items="${matBangs}" var="c">
                            <option value="${c.getIdMatBang()}">${c. getNameMatBang()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Gia cho thue: </label>
                <div class="col-9">
                    <input type="text" name="e" class="form-control">
                </div>
            </div>
            <div class="row mb-3 mt-3">
                <label class="col-3">Ngay bat dau: </label>
                <div class="col-9">
                    <input type="date" name="f" class="form-control">
                </div>
            </div>
            <div class="row mb-3 mt-3">
                <label class="col-3">Ngay ket thuc: </label>
                <div class="col-9">
                    <input type="date" name="g" class="form-control">
                </div>
            </div>
            <div class="row ">
                <%--                <label class="col-3" for=""></label>--%>
                <div class="col-9 offset-3">
                    <button class="btn btn-primary" type="submit">Create</button>
                    <a href="/choThues"><button class="btn btn-dark" type="button">Back</button></a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
