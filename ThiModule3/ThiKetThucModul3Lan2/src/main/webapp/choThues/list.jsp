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
        <a href="/choThues?action=create"><button class="btn btn-primary" type="submit">Create</button></a>
        <form class="d-flex" method="get">
            <input type="date" name="action" id="action" value="ngay bat dau">
            <label> Đến </label>
            <input type="date" name="action" id="action1" value="ngay ket thuc">
            <br>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
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
                <th>Dien Tich</th>
                <th>Trang Thai</th>
                <th>Tang</th>
                <th>Loai Van Phong</th>
                <th>Gia Cho Thue</th>
                <th>Ngay Bat Dau</th>
                <th>Ngay Ket Thuc</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${choThueList}" var="i">
                <tr>
                    <td>${i.getId()}</td>
                    <td>${i.getDienTich()}</td>
                    <c:forEach items="${matBangList}" var="ct">
                        <c:if test="${ct.getIdMatBang() == i.getNameMatBang().getIdMatBang()}">
                            <td>
                                    ${ct.getNameMatBang()}
                            </td>
                        </c:if>
                    </c:forEach>
                    <td>${i.getTang()}</td>
                    <c:forEach items="${trangThaiList}" var="ct">
                        <c:if test="${ct. getIdTrangThai() == i.getNameTrangThai(). getIdTrangThai()}">
                            <td>
                                    ${ct.getNameTrangThai()}
                            </td>
                        </c:if>
                    </c:forEach>
                    <td>${i.getGia()}</td>
                    <td>${i.getNgayBatDau()}</td>
                    <td>${i.getNgayKetThuc()}</td>
                    <td>
                        <a class="offset-1" onclick="handleDeleteClick(${i.getId()})"><i class="fa-solid fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function handleDeleteClick(id) {
        Swal.fire({
            title: "Bạn chắc chắn chứ?",
            text: "Bạn có muốn xóa không?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Có, xóa đi!",
            htmlMode: true
        }).then((result) => {
            if (result.isConfirmed) {
                location.assign("/choThues?action=delete&id=" + id);
            }
        });
    }
</script>
</body>
</html>
