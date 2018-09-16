<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 14.08.18
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>
<form class="form-inline" action="/admin/report-profits" method="post">
    <div class="form-group">
        <label>Date from </label>
        <input type="date" class="form-control" placeholder="From" name="from" style="margin-left: 5px; margin-right: 5px">
    </div>
    <div class="form-group">
        <label>Date to   </label>
        <input type="date" class="form-control" placeholder="To" name="to" style="margin-left: 5px; margin-right: 5px">
    </div>
    <button type="submit" class="btn-sm btn-primary">Display <i class="fas fa-share-square"></i></button>
</form>
<!-- Page Content -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-hand-holding-usd"></i>
        Profit report</div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Order Id</th>
                    <th>Profit/Loss</th>
                </thead>
                <tfoot>
                <tr>
                    <th>Order Id</th>
                    <th>Profit/Loss</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="line" items="${report}">
                    <tr>
                    <tr>
                        <td>${line[0]}</td>
                        <td>${line[1]}</td>
                    </tr>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</html>
