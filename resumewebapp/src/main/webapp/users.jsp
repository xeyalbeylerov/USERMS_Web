<%@ page import="com.company.entity.User" %>
<%@ page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%
    //    UserDaoInter userDao = Context.instanceUserDao();
//
//    String name = request.getParameter("name");
//    String surname = request.getParameter("surname");
//
//    String nationalityIdStr = request.getParameter("nid");
//    Integer nationalityId = null;
//    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
//        nationalityId = Integer.parseInt(nationalityIdStr);
//    }
////    out.print("name " + name);
////    out.print("surname " + surname);
////    out.print("nation " + nationalityId);
//    List<User> lists = userDao.getAll(name, surname, nationalityId);
    List<User> lists = (List<User>) request.getAttribute("userList");


%>
<div class="container">
    <div>
        <!--Form here -->
        <form action="users" method="get" class="form-inline">
            <div class="form-group mb-2">
                <label for="name" class="sr-only">name </label>
                <input class="form-control" type="text" name="name" id="name" value="" placeholder="type name here">
            </div>
            <div class="form-group mx-sm-3 mb-2">
                <label for="surname" class="sr-only">surname</label>
                <input class="form-control" type="text" name="surname" id="surname" value=""
                       placeholder="type surname here">
            </div>
            <div class="form-group mb-2">
                <input class="btn btn-primary" type="submit" name="search" value="Search">

                <button class="btn btn-success mx-2" type="button" value="add"
                        data-toggle="modal"
                        data-target="#addModal">Add
                </button>
            </div>
        </form>

        <div>
            <!--Table here -->
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col" class="text-center">name</th>
                    <th scope="col" class="text-center">surname</th>
                    <th scope="col" class="text-center">nationality</th>
                    <th scope="col" class="text-center"></th>
                    <th scope="col" class="text-center"></th>
                    <th scope="col" class="text-center"></th>
                </tr>
                </thead>
                <tbody>
                <%for (User list : lists) {%>
                <tr scope="row">
                    <td><%=list.getName()%>
                    </td>
                    <td><%=list.getSurname()%>
                    </td>
                    <td><%=list.getNationality() == null ? "N/A" : list.getNationality().getName()%>
                    </td>
                    <td style="width:5px;">
                        <form action="userdetail" method="get">
                            <input type="hidden" name="id" value="<%=list.getId()%>"/>
                            <input type="hidden" name="action" value="update"/>
                            <button class="btn btn-warning" type="submit" value="update">Edit</button>
                        </form>
                    </td>
                    <td style="width:5px;">

                        <button onclick="idForDeleteModal('<%=list.getId()%>')" class="btn btn-danger" type="button"
                                value="delete" data-toggle="modal"
                                data-target="#deleteModal">Delete
                        </button>

                    </td>
                    <%--<td style="width:5px;">--%>
                        <%--<form action="userdetail" method="get">--%>
                            <%--<input type="hidden" name="id" value="<%=list.getId()%>"/>--%>
                            <%--<button class="btn btn-secondary" type="submit" name="action" value="info">Info</button>--%>
                        <%--</form>--%>
                    <%--</td>--%>
                    <td style="width:5px;">
                        <button onclick="idForInfoModal('<%=list.getId()%>')" class="btn btn-secondary" type="button"
                                value="info" data-toggle="modal"
                                data-target="#infoModal">Info
                        </button>

                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!--Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete user</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="post">
                    <input type="hidden" name="id" id="idForDeleteModal" value=""/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>

        </div>
    </div>
</div>
<!--Add Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addModalLabel">Add user</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="userdetail" method="post" class="form-inline" autocomplete="off">
            <div class="modal-body">
                    <input type="hidden" name="action" value="add"/>

                    <div class="form-group mb-2">
                        <label for="email" class="sr-only">Email</label>
                        <input class="form-control" type="email" name="email" id="email" value=""
                               placeholder="type email here">
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="password" class="sr-only">surname</label>
                        <input class="form-control" type="password" name="password" id="password" value=""
                               placeholder="type password here">
                    </div>
                    <div class="form-group mb-2">
                        <label for="addName" class="sr-only">Name</label>
                        <input class="form-control" type="text" name="name" id="addName" value=""
                               placeholder="type name here">
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="addSurname" class="sr-only">surname</label>
                        <input class="form-control" type="text" name="surname" id="addSurname" value=""
                               placeholder="type surname here">
                    </div>

            </div>
            <div class="modal-footer">


                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Add</button>

            </div>
            </form>
        </div>
    </div>
</div>

<!--Info Modal -->
<%--<div class="modal fade" id="infoModal2" tabindex="-1" role="dialog" aria-labelledby="infoModalLabel2"--%>
     <%--aria-hidden="true">--%>
    <%--<div class="modal-dialog" role="document">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<h5 class="modal-title" id="infoModalLabel2">Info user</h5>--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                    <%--<span aria-hidden="true">&times;</span>--%>
                <%--</button>--%>
            <%--</div>--%>
            <%--<div class="modal-body">--%>
                <%--//module bod--%>
                <%--<%--%>
                    <%--User u = (User) request.getAttribute("user");--%>
                <%--%>--%>

                <%--<%=u.getName() == null ? "" : u.getName()%>"--%>


            <%--</div>--%>
            <%--<div class="modal-footer">--%>

                <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="assets/js/users.js"></script>
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
