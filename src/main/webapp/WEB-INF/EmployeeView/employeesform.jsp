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
<h1 style="text-align: center;"> Add employee</h1>
<hr>
<form action="/admin/employee-add" method="post">
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Name</label>
        <input type="text" class="form-control" placeholder="Name" name="name" required>
        </label>

    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Surname</label>
        <input type="text" class="form-control" placeholder="Surname" name="surname" required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Address</label>
        <input type="text" class="form-control" placeholder="Address" name="address" required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Contact</label>
        <input type="text" class="form-control" placeholder="Contact" name="phone" required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Note</label>
        <input type="text" class="form-control" placeholder="Note" name="note">
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Salary</label>
        <input type="number" min="0.01" step="0.01" class="form-control" placeholder="Salary" name="manhourValue"
               required>
        </label>
    </div>

    <button type="submit" class="btn-lg btn-primary" style="float: right" value="submit">Add <i class="fas fa-plus"></i>
    </button>
</form>

<jsp:include page="../fragments/footer.jsp"/>
</html>
