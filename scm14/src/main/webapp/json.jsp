<%@include file="common/common.jsp" %>
<html>
<head>

    <%--<c:set var="proPath" value="${pageContext.request.contextPath}"/>--%>
    <%--<link rel="stylesheet" type="text/css"--%>
    <%--href="${proPath}/jquery-easyui-1.3.5/themes/default/easyui.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="${proPath}/jquery-easyui-1.3.5/themes/icon.css">--%>
    <%--<script type="text/javascript" src="${proPath}/jquery-easyui-1.3.5/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="${proPath}/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>--%>


    <title>用来测试json</title>
    <script type="text/javascript">
        //当整个页面加载完成之后调用这个方法
        $(function () {
                    $("#bt1").click(
                            function () {
                                $.post(
                                        "supplier/doAjax.action",
                                        {supId: 1001, supName: "name1001"},//json传送
                                        function (json) {
                                            alert(json.supId + "||" + json.supName);
                                        },
                                        "json"
                                );
                            }
                    );
                }
        );

    </script>

</head>
<body>
<button id="bt1">testJson</button>
</body>
</html>