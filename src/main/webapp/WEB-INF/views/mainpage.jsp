<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <style>
        h1 {
            color: white;
            font-size: 300%;
        }

        .header-design {
            padding: 1em;
            color: white;
            background-color: #F4D03F;
            clear: left;
        }

        .button {
            background-color: yellow;
            border: blue;
            color: blue;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
        frame {
            overflow: hidden;
        }
        .menu {
            float:left;
            width:20%;
            height:80%;
        }
        .mainContent {
            float:left;
            width:75%;
            height:80%;
        }
    </style>
</head>
<body>
    <%--<iframe src="header.jsp" frameborder="0" class="menu"></iframe>--%>
    <iframe src="menu.jsp" frameborder="0" class="mainContent"></iframe>
    <h2>Main Page</h2>
</body>
<%--<frameset rows="14%,79%,7%">
    <frame scrolling="no" frameborder="0" name="f1" src="header"></frame>
    <frameset cols="9%,70%">
        <frame scrolling="no" name="f4" src="menu.jsp" style="background-color:#D4AF37"></frame>
        <frame scrolling="no" name="f5" src="homepage.jsp"></frame>
    </frameset>
    <frame scrolling="no" frameborder="0" name="f3" src="footer.jsp"></frame>
</frameset>--%>
</html>

