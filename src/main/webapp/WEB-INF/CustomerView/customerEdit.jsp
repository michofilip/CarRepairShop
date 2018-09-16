<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 14.08.18
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../fragments/header.jsp"/>


<h1 style="text-align: center;"> Edit client</h1>
<hr>
<form action="/admin/customer-edit" method="post">
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Client Id</label>
        <input type="text" class="form-control" value="${customer.id}" placeholder="Name" name="id" readonly required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Name</label>
        <input type="text" class="form-control" value="${customer.name}" placeholder="Name" name="name" required>
        </label>

    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Surname</label>
        <input type="text" class="form-control" value="${customer.surname}" placeholder="Surname" name="surname"
               required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Birthday</label>
        <input class="form-control" placeholder="Birthday" value="${customer.birthday}" type="date" name="birthday">
        </label>

    </div>
    <button type="submit" class="btn-lg btn-primary" style="float: right" value="submit">Add <i class="fas fa-plus"></i>
    </button>
</form>


<jsp:include page="../fragments/footer.jsp"/>
</html>
