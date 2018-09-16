<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 14.08.18
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>
<h1 style="text-align: center;">Edit order</h1>
<hr>
<form action="/admin/orders-edit" method="post">
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>ID</label>
        <input type="text" class="form-control" value="${order.id}" placeholder="id" name="id" readonly required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Recieved</label>
        <input type="Date" class="form-control" value="${order.received}" placeholder="Date recieved" name="recieved"
               required>
        </label>

    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Planned beginning</label>
        <input type="date" class="form-control" value="${order.planedBeginning}" placeholder="Planned beginnging"
               name="planedBeginning">
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Begun</label>
        <input type="Date" class="form-control" value="${order.begun}" placeholder="begun" name="begun">
        </label>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect4">Worker</label>
        <select class="form-control" id="exampleFormControlSelect4" name="employeeId" required>
            <c:forEach var="employee" items="${employees}">
                <option value="${employee.id}" ${order.employee.id == employee.id ? 'selected' : ''}>
                    Id:${employee.id} - ${employee.name} ${employee.surname}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Problem description</label>

        <textarea class="form-control" placeholder="Problem description"
                  name="problemDescription">${order.problemDescription}</textarea>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Repair description</label>

        <textarea class="form-control" placeholder="Repair description"
                  name="repairDescription">${order.repairDescription}</textarea>
        </label>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Status</label>
        <select class="form-control" id="exampleFormControlSelect1" name="status" required>
            <c:forEach var="stat" items="${statuses}">
                <option value="${stat}" ${order.status == stat ? 'selected' : ''}>
                        ${stat.description}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect2">Vehicle</label>
        <select class="form-control" id="exampleFormControlSelect2" name="vehicleId" required>
            <c:forEach var="vehicle" items="${vehicles}">
                <option value="${vehicle.id}"  ${order.vehicle.id == vehicle.id ? 'selected' : ''}>
                    Id:${vehicle.id} - ${vehicle.brand} ${vehicle.model}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Price</label>
        <input type="Number" min="10" step="0,01" class="form-control" value="${order.price}" placeholder="Price"
               name="price">
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Expenses</label>
        <input type="Number" min="10" step="0,01" class="form-control" value="${order.expense}" placeholder="expenses"
               name="expenses">
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Manhours</label>
        <input type="Number" min="1" step="1" class="form-control" value="${order.manhours}" placeholder="manhours"
               name="manhours">
        </label>
    </div>


    <button type="submit" class="btn-lg btn-primary" style="float: right" value="submit">Add <i class="fas fa-plus"></i>
    </button>
</form>

<jsp:include page="../fragments/footer.jsp"/>
</html>