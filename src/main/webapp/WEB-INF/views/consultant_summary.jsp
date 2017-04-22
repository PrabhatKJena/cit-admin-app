<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>consultant summary</title>
    <style>
        body {
            background-color: lightblue;
            text-align: center;
        }
    </style>
    <style>
        table.content-tbl {
            border: 1px solid black;
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        .content-tbl td, th {
            text-align: left;
            border: 1px solid #dddddd;
            text-align: left;
            padding: 10px;
        }

        .content-tbl tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body>
<h1 align="center"> Conslutant Summary</h1>

<input type="text" value="name"> <input type="text" value="skill"> <select name="quater">
    <option value="Q1 2017">Q1 2017</option>
    <option value="Q2 2017">Q2 2017</option>
    <option value="Q3 2017">Q3 2017</option>
</select> is active <input type="button" value="search"><input type="button" value="onboard new">

<br> <br>

<table class="content-tbl">
    <div>
        <tr>
            <th>C ID</th>
            <th>name</th>
            <th>phone</th>
            <th>email</th>
            <th>skills</th>
            <th>Date of Onboard</th>
            <th>Last Active from</th>
        </tr>
    </div>
    <tr>
        <td>001</td>
        <td>abc</td>
        <td>123748759</td>
        <td>sdsdh@dsf.in</td>
        <td>js, java</td>
        <td></td>
        <td></td>
        <td><input type="button" value="Edit"></td>
    </tr>
    <tr>
        <td>002</td>
        <td>dcv</td>
        <td>123748759</td>
        <td>sddsfadf@dsf.in</td>
        <td>js, dcdS</td>
        <td>DSD</td>
        <td>DFBVFB</td>
        <td><input type="button" value="Edit"></td>
    </tr>
    <tr>
        <td>003</td>
        <td>dfsv</td>
        <td>123748759</td>
        <td>sddfsbnh@dsf.in</td>
        <td>sql, java</td>
        <td>sdvfgv</td>
        <td>vc</td>
        <td><input type="button" value="Edit"></td>
    </tr>


</table>
</body>
</html>