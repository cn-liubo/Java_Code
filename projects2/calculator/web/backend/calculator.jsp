<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/12/2
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算机页面</title>
<%--    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>

</head>
<body>
<strong>欢迎来的简易计算机</strong>
<hr size="2" color="black">

<%--<script type="text/javascript">--%>

<%--</script>--%>
计算结果：${num}
<div>
    <center>
        <form action="/myWeb/calculator">
            <table bgcolor="#eee8aa" border="1" >
                <tr>
                    <td width="400" height="40" colspan="2"><div align="center">我的计算器</div></td>
                </tr>
                <tr>
                    <td width="200" height="40"><div align="center">第一个参数：</div></td>
                    <td width="200" height="40"><input type="text" name="firstParameter" value="${firstParameter}"></td>
                </tr>
                <tr>
                    <td width="200" height="40"><div align="center">运算符：</div></td>
                    <td width="200" height="40">
                        <select id="previous" name="operator" value="operator">
                            <option value="+" >+</option>
                            <option value="-">-</option>
                            <option value="*">*</option>
                            <option value="/">/</option>
                            <option value="%">%</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="200" height="40"><div align="center">第二个参数：</div></td>
                    <td width="200" height="40"><input type="text" name="secondParameter" value="${secondParameter}"></td>
                </tr>
                <tr>
                    <td width="400" height="40" colspan="2">

                        <input type="submit" value="计算"/>

                    </td>

                </tr>
            </table>
        </form>
    </center>
</div>
</body>
</html>