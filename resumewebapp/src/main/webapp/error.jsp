<%@ page import="com.company.dao.inter.UserDaoInter" %>
<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.main.Context" %>
<%@ page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Error Page</title>
</head>
<body>
<%=request.getParameter( "msg")%>

</body>
</html>