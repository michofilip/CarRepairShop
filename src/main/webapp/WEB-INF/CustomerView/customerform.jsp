<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 13.08.18
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../fragments/header.jsp"/>


<h1 style="text-align: center;"> Add client</h1>
<hr>
<form action="/admin/customer-add" method="post">
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
        <label>Birthday</label>
        <input class="form-control" placeholder="Birthday" type="date" name="birthday">
        </label>

    </div>
    <button type="submit" class="btn-lg btn-primary" style="float: right" value="submit">Add <i class="fas fa-plus"></i>
    </button>
</form>


<jsp:include page="../fragments/footer.jsp"/>
</html>


