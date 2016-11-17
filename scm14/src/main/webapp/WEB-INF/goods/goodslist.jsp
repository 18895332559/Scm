<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/common.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        $(function () {

            $('#dg').datagrid({
                url: 'datagrid_data1.json',
                columns: [[
                    {field: 'productid', title: '产品编号', width: 100},
                    {field: 'productname', title: '产品名称', width: 100},
                    {field: 'listprice', title: '价格', width: 100, align: 'right'}
                ]]
            });

        });
    </script>
</head>

<body>
<%--创建dategrid--%>
<table id="dg"></table>
</body>
</html>