<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 14.08.18
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>

<!-- Page Content -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-user-astronaut"></i>
        Employees
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Address</th>
                    <th>Contact</th>
                    <th>Note</th>
                    <th>Salary</th>
                    <th>Orders</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Address</th>
                    <th>Contact</th>
                    <th>Note</th>
                    <th>Salary</th>
                    <th>Orders</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.surname}</td>
                        <td>${employee.address}</td>
                        <td>${employee.phone}</td>
                        <td>${employee.note}</td>
                        <td>${employee.manhourValue}</td>
                        <td><a href="/admin/orders-show?employeeId=${employee.id}">Orders</a></td>
                        <td><a href="/admin/employee-del?id=${employee.id}">Delete<i class="fas fa-trash-alt"></i></a></td>
                        <td><a href="/admin/employee-edit?id=${employee.id}">Edit<i class="fas fa-edit"></i></a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <a href="/admin/employee-add" class="btn btn-primary" style="float: right" role="button">Add </a>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</html>

