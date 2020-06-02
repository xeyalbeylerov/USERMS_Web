<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.entity.UserSkill" %>
<%@ page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="userdetail.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%


    User u = (User) request.getAttribute("user");
//    User u = null;
//    try {
//        u = UserRequestUtil.processRequest(request, response);
//    } catch (Exception ex) {
//        response.sendRedirect("error.jsp?msg=" + ex.getMessage()+" Test");
//        return;
//    }
%>

<div class="position-fixed">
    <%--<div class="p-2 my-flex-item text-right">1dwdwd</div>--%>
    <form action="userdetail" method="post">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <input type="hidden" name="action" value="update"/>
        <button type="submit" class="btn btn-warning text-right">Update</button>

</div>
<table class="table table-striped container">
    <thead>
    <tr>
        <th scope="col" class="text-center" width="30%">#</th>
        <th scope="col" class="text-center" width="70%">Details</th>

    </tr>
    </thead>
    <tbody>
    <tr scope="row">
        <td>Id</td>
        <td><%=u.getId()%>
        </td>
    </tr>

    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="<%=u.getName() == null ? "" : u.getName()%>"/>

    <label for="surname">Surname</label>
    <input type="text" id="surname" name="surname" value="<%=u.getSurname() == null ? "" : u.getSurname()%>"/>

    <label for="address">Address</label>
    <input type="text" id="address" name="address" value="<%=u.getAddress() == null ? "" : u.getAddress()%>"/>

    <label for="email">Email</label>
    <input type="email" id="email" name="email" value="<%=u.getEmail() == null ? "" : u.getEmail()%>"/>


    <%
        List<UserSkill> userSkills = u.getSkills();
        if (userSkills.size() == 0) {
            out.println("Skill is empty");
        } else {
    %><label for="skills">Skills</label><select id="skills" name="skills" size="<%=userSkills.size()%>"><%
        for (UserSkill userSkill : userSkills) {
    %>
        <option value="<%=userSkill.getSkill().getId()%>"><%=userSkill.getSkill().getName()%>
        </option>
        <%
            }
        %></select><br><br><%
        }

    %>

        <%--<tr scope="row">--%>
        <%--<td>Skills</td>--%>
        <%--<td><input class="form-control" type="text" name="name" value="<%--%>
        <%--List<UserSkill> userSkills=u.getSkills();--%>
        <%--if(userSkills.size()==0){--%>
        <%--out.println("Skill is empty");--%>
        <%--}else {--%>

        <%--for(UserSkill userSkill:userSkills){--%>
        <%--out.println( userSkill.getSkill().getName());--%>
        <%--}}--%>

        <%--%>"/></td>--%>
        <%--&lt;%&ndash;<td><%=u.getSkills() == null ? "N/A" : u.getSkills()%>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</td>&ndash;%&gt;--%>

        <%--</tr>--%>

        <label for="profile_description">Profile description</label>
        <input type="text" id="profile_description" name="profile_description"
               value="<%=u.getProfileDesc() == null ? "" : u.getProfileDesc()%>"/>

        <label for="birth_date">Birth Date</label>
        <input type="date" id="birth_date" name="birth_date"
               value="<%=u.getBirthDate() == null ? "" : u.getBirthDate()%>"/>
    <%=u.getBirthDate() == null ? "" : u.getBirthDate()%>
        <label for="birth_place">Birth Place</label>
        <input type="text" id="birth_place" name="birth_place"
               value="<%=u.getBirthPlace() == null ? "" : u.getBirthPlace().getName()%>"/>

        <label for="phone">Phone</label>
        <input type="tel" id="phone" name="phone"
               value="<%=u.getPhone() == null ? "" : u.getPhone()%>"/>
    </form>
    </tbody>
</table>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
