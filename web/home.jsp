
<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Category> allCategory = (List<Category>) request.getAttribute("allCategory");%>

<html>
<head>
    <title>Home</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<div class="main">
    <div class="header"><img src="img/web-development-banner.jpg"></div>

    <div class="left">
        <% if (request.getAttribute("allPost") != null) {%>
        <%List<Post> allPost = (List<Post>) request.getAttribute("allPost");%>

        <div class="leftInfo">
            <% for (Post post : allPost) {%>
            <h4><%=post.getTitle()%>
            </h4>
            <img src="/getImage?fileName=<%=post.getImage()%>" width="530" height="100px"> <br>
            <span><%=post.getCreatedDate()%></span> <br>
            <p><%=post.getDescription()%>
            </p>
            <br> <br>
            <%
                }
            %>
            <%
            } else {
                List<Post> allThePosts = (List<Post>) request.getAttribute("allThePosts");%>
            <div class="leftInfo">
                <% for (Post post : allThePosts) {%>
                <h4><%=post.getTitle()%>
                </h4>
                <img src="/getImage?fileName=<%=post.getImage()%>" width="530" height="100px"> <br>
                <span><%=post.getCreatedDate()%></span> <br>
                <p><%=post.getDescription()%>
                </p>
                <br> <br>
                <%
                    }
                %>
                <%
                    }
                %>
            </div>
        </div>
    </div>

        <div class="right">
            <div class="rightInfo">
                <% if (allCategory != null) {
                    for (Category category : allCategory) {%>
                <ul>
                    <li>
                        <a href="/home?categoryId=<%=category.getId()%>"><%=category.getName()%>
                        </a>
                    </li>
                </ul>
                <%
                        }
                    }
                %>
            </div>
            <div><h3><a href="/admin"> Admin panel</a></h3></div>

        </div>
</div>
</body>
</html>
