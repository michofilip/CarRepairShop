<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 13.08.18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<jsp:include page="../fragments/header.jsp"/>


<!-- Page Content -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas  fa-users"></i>
        Clients
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Samochody</th>
                    <th>Date of birth</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Samochody</th>
                    <th>Date of birth</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.surname}</td>
                        <td><a href="/admin/vehicles-show?ownerId=${customer.id}">Cars</a></td>
                        <td>${customer.birthday}</td>
                        <td><a href="/admin/customer-del?id=${customer.id}">Delete <i class="fas fa-trash-alt"></i></a></td>
                        <td><a href="/admin/customer-edit?id=${customer.id}">Edit <i class="fas fa-edit"></i></a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <a href="/admin/customer-add" class="btn btn-primary" style="float: right" ole="button">Add </a>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>
<jsp:include page="../fragments/footer.jsp"/>

</html>
