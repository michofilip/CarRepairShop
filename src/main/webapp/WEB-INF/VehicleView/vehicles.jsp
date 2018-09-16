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
        <i class="fas fa-car-alt"></i>
        Vehicles
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Model</th>
                    <th>Brand</th>
                    <th>Production</th>
                    <th>Next checkup</th>
                    <th>Owner</th>
                    <th>Delete</th>
                    <th>Edit</th>

                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Model</th>
                    <th>Brand</th>
                    <th>Production</th>
                    <th>Next checkup</th>
                    <th>Owner</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="vehicle" items="${vehicles}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.model}</td>
                        <td>${vehicle.brand}</td>
                        <td>${vehicle.productionYear}</td>
                        <td>${vehicle.nextCheckup}</td>
                        <td>
                            <a href="/admin/customer-show?id=${vehicle.owner.id}">#${vehicle.owner.id} ${vehicle.owner.name} ${vehicle.owner.surname}</a>
                        </td>
                        <td><a href="/admin/vehicle-delete?id=${vehicle.id}">Delete <i class="fas fa-trash-alt"></i></a></td>
                        <td><a href="/admin/vehicle-edit?id=${vehicle.id}">Edit <i class="fas fa-edit"></i></a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <a href="/admin/vehicle-add" class="btn btn-primary" style="float: right" role="button">Add </a>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>

<jsp:include page="../fragments/footer.jsp"/>

</html>
