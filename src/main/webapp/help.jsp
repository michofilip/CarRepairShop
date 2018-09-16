<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 14.08.18
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="WEB-INF/fragments/header.jsp"/>
<h1 style="text-align: center;">Contact support</h1>
<hr>
<form method="post">
    <div class="form-group ">
        <label class="control-label " for="name">
            Name
        </label>
        <input class="form-control" id="name" name="name" type="text"/>
    </div>
    <div class="form-group ">
        <label class="control-label requiredField" for="email">
            Email
            <span class="asteriskField">
        *
       </span>
        </label>
        <input class="form-control" id="email" name="email" type="text"/>
    </div>
    <div class="form-group ">
        <label class="control-label " for="subject">
            Subject
        </label>
        <input class="form-control" id="subject" name="subject" type="text"/>
    </div>
    <div class="form-group ">
        <label class="control-label " for="message">
            Message
        </label>
        <textarea class="form-control" cols="40" id="message" name="message" rows="10"></textarea>
    </div>
    <div class="form-group">
        <div>
            <button class="btn-lg btn-primary "  style="float: right" name="submit" type="submit">
                Submit
            </button>
            <small>*Hotline: 523-663-623 </small>
        </div>
    </div>
</form>

<jsp:include page="WEB-INF/fragments/footer.jsp"/>
</html>
