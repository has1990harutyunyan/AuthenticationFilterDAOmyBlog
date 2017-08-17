<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%List<Category> allCategory = (List<Category>) request.getAttribute("allCategory");%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h3 style="color: darkblue"> add Category: </h3>

<form action="/addCategory" method="post">
    name: <br> <input type="text" name="categoryName"> <br><br>
    <input type="submit">
</form>

<br>

<h3 style="color: darkblue"> add Post: </h3>

<form action="/addPost" method="post" enctype="multipart/form-data">
    title: <br><input type="text" name="title"> <br><br>
    category:
    <select name="categoryId">
        <% if (allCategory != null) {
            for (Category category : allCategory) {
        %>
        <option value="<%=category.getId()%>"><%=category.getName()%>
        </option>

        <%
                }
            }
        %>
    </select><br><br>


    description:<br><input type="text" name="description"> <br><br>
    image: <input type="file" name="pic"><br><br>
    <input type="submit">
</form>


</body>
</html>
