<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 13.08.18
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>
<!-- DataTables Example -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-wrench"></i>
        Repairs in progress
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Order Id</th>
                    <th>Worker</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Order Id</th>
                    <th>Worker</th>
                </tr>
                </tfoot>
                <tbody>

                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td><a href="/admin/orders-show?id=${order.id}"> ${order.id}</a></td>
                        <td>
                            <a href="/admin/employees-show?id=${order.employee.id}"> ${order.employee.name} ${order.employee.surname}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Ostatnia akutalizacja:</div>
</div>


<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
