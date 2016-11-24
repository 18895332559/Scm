<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/common.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        $(function () {
            //拿到商品采购的窗体
            var win = parent.$("iframe[title='商品采购']").get(0).contentWindow;//返回ifram页面窗体对象（window)

            $('#dg').datagrid({
                url: '${proPath}/goods/selectPageUseDyc.action',
                fitColumns: true,
                nowrapL: true,
                idField: 'goodsId',
                rownumbers: true,
                pagination: true,
                pageSize: 5,
                pageList: [2, 5, 10, 20],
                singleSelect: true,//单选
                toolbar: [{
                    iconCls: 'icon-add',
                    text: '新增',
                    handler: function () {
                        var row = $("#dg").datagrid("getSelected");
                        if (row == null) {
                            alert("请选择要采购的商品");
                            return false;
                        }
                        alert(row.goodsId + ":" + row.goodsName);

                        win.$("#dg").datagrid("appendRow", { //在末尾添加行
                            goodsId: row.goodsId,
                            goodsName: row.goodsName,
                            goodsUnit: row.goodsUnit,
                            goodsType: row.goodsType,
                            goodsColor: row.goodsColor,
                            bodAmount: $("#bodAmount").val(),
                            bodBuyPrice: $("#bodBuyPrice").val(),
                            bodTotalPrice: $("#bodBuyPrice").val() * $("#bodAmount").val(),
                            bodImeiList: $("#bodImeiList").val()
                        });
                        parent.$("#win").window("close"); //关闭新增窗口
                    }

                }, '-', {
                    text: "名称：<input type='text' id='goodsName' name='goodsName'/>"
                }],

                columns: [[{
                    checkbox: true
                }, {
                    field: 'goodsId',
                    title: '商品编号'
                }, {
                    field: 'goodsName',
                    title: '商品名称',
                    width: 100
                }, {
                    field: 'goodsUnit',
                    title: '单位',
                    width: 100
                }, {
                    field: 'goodsType',
                    title: '型号',
                    width: 100
                }, {
                    field: 'goodsColor',
                    title: '颜色',
                    width: 100
                }]]
            });

        });
    </script>
</head>

<body>
<%--创建dategrid--%>
<table id="dg"></table>
<form style="padding:5px;margin:0px;background:#eee;" action="">
    采购数量：<input type="text" id='bodAmount' name='bodAmount' class="easyui-numberbox" value="1"
                data-options="min:1,max:1000000000">
    价格：<input type="text" id='bodBuyPrice' name='bodBuyPrice' class="easyui-numberbox" value="22"
              data-options="min:0,precision:2">
    手机串号：<textarea id='bodImeiList' name='bodImeiList'>3333</textarea>

</form>
</body>
</html>