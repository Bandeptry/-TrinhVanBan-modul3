<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 19/12/2023
  Time: 08:44 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 18/12/2023
  Time: 08:53 p.m.
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
        <form method="post">
            <h4>Create</h4>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-danger">
                    <label>${requestScope.message}</label>
                </div>
            </c:if>
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
                <label class="col-3">Tên sản phẩm : </label>
                <div class="col-9">
                    <input type="text" name="name" class="form-control" value="${productList.getTenSanPham()}">
                </div>
            </div>
            <div class="row mb-3 mt-3">
                <label class="col-3">Giá: </label>
                <div class="col-9">
                    <input type="text" name="gia" class="form-control" value="${productList.getGia()}">
                </div>
            </div>
            <div class="row mb-3 mt-3">
                <label class="col-3">Số lượng: </label>
                <div class="col-9">
                    <input type="text" name="soLuong" class="form-control" value="${productList.getSoLuong()}">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Màu sắc: </label>
                <div class="col-9">
                    <input type="text" name="mauSac" class="form-control" value="${productList.getMauSac()}">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Mô Tả: </label>
                <div class="col-9">
                    <input type="text" name="moTa" class="form-control" value="${productList.getMoTa()}">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-3">Danh Mục: </label>
                <div class="col-9">
                    <select class="form-select" aria-label="Default select example" value="${productList.getCategory().getCategory()}">
                        <option>Chọn danh mục</option>
                        <option value = "1">Iphone</option>
                        <option value= "2">MasTel</option>
                        <option value= "3">VinaPhone</option>
                    </select>
                </div>
            </div>
            <div class="row ">
                <%--                <label class="col-3" for=""></label>--%>
                <div class="col-9 offset-3">
                    <button class="btn btn-primary" type="submit">Create</button>
                    <a href="/customers"><button class="btn btn-dark" type="button">Back</button></a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>


