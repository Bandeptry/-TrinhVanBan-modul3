<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 18/12/2023
  Time: 08:33 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css"
          integrity="sha512-Ez0cGzNzHR1tYAv56860NLspgUGuQw16GiOOp/I2LuTmpSK9xDXlgJz3XN4cnpXWDmkNBKXR/VDMTCnAaEooxA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.10.1/sweetalert2.css" integrity="sha512-pxzljms2XK/DmQU3S58LhGyvttZBPNSw1/zoVZiYmYBvjDQW+0K7/DVzWHNz/LeiDs+uiPMtfQpgDeETwqL+1Q=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.10.1/sweetalert2.min.js" integrity="sha512-lhtxV2wFeGInLAF3yN3WN/2wobmk+HuoWjyr3xgft42IY0xv4YN7Ao8VnYOwEjJH1F7I+fadwFQkVcZ6ege6kA=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<body>
<div class="container">
    <div class="head d-flex justify-content-between mt-3">
        <a href="/products?action=create"><button class="btn btn-primary" type="submit">Create</button></a>
        <a href=""><button class="btn btn-dark">Back</button></a>
    </div>
    <div class="center">
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
        <c:if test="${messageEdit != null}">
            <script>
                window.onload = ()=>
                {
                    Swal.fire({
                        position: "top-end",
                        icon: "success",
                        title: "${sessionScope.messageEdit}",
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            </script>
        </c:if>
        <c:if test="${messageDelete != null}">
            <script>
                window.onload = ()=>
                {
                    Swal.fire({
                        position: "top-end",
                        icon: "success",
                        title: "${sessionScope.messageDelete}",
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            </script>
        </c:if>
        <table class="table table-striped">
            <thead>
            <tr class="col-4">
                <th>#</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Category</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="i">
                <tr>
                    <td>${i.getId()}</td>
                    <td>${i.getTenSanPham()}</td>
                    <td>${i.getGia()}</td>
                    <td>${i.getSoLuong()}</td>
                    <td>${i.getMauSac()}</td>
                    <td>${i.getCategory().getCategory()}</td>
                    <td>
                        <a href="/products?action=edit&id=${i.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                        <a class="offset-1" href="/products?action=delete&id=${i.getId()}" onclick="handelDeleteClick(${i.getId()}, '${i.getTenSanPham()}')"><i class="fa-solid fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function handelDeleteClick(id, name) {
        Swal.fire({
            title: "Are you sure?",
            text: "Bạn có muốn xóa " + name + " không?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, delete it!",
            htmlMode: truex
        }).then((result) => {
            console.log(id);
            if (result.isConfirmed) {
                location.assign("/customers?action=delete&id=" + id);
            }
        });
    }
</script>
</body>
</html>
