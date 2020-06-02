<%@ page import="com.company.entity.User" %>
<html>
<body>
<h2>Hello World!3</h2>
<a href="users">sqsqsqsd</a>
<%User user=(User)session.getAttribute("loggedInUser");
out.print("Welcome "+user.getName());
%>
</body>
</html>
