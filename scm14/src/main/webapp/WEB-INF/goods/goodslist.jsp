<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/common.jsp" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        $(function () {

            $('#dg').datagrid({
                url: '${proPath}/goods/selectPageUseDyc.action',
                fitColumns: true,
                nowrapL: true,
                idField: 'goodsId',
                rownumbers: true,
                pagination: true,
                pageSize: 5,
                pageList: [2, 5, 10, 20],

                toolbar: [{
                    iconCls: 'icon-add',
                    text: '新增',
                    handler: function () {
                        alert('新增按钮');
                        /* 	parent.$('#win').window({
                         title :'添加供应商',
                         width:600,
                         height:400,
                         modal:true,
                         content:"<iframe src='
                        ${proPath}/base/goURL/supplier/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                         });  */
                    }


                }, '-', {
                    iconCls: 'icon-edit',
                    text: '修改',
                    handler: function () {
                        alert('修改按钮');
                        //判断是否选中一行，并且只能选中一行进行修改
                        /* var array = $('#dg').datagrid("getSelections");
                         if(array.length!=1){
                         alert("请选择需要修改的记录，并且只能选中一条！");
                         return false;
                         }

                         //打开修改窗口
                         parent.$('#win').window({
                         title :'修改供应商',
                         width:600,
                         height:400,
                         modal:true,
                         content:"<iframe src='
                        ${proPath}/base/goURL/supplier/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                         });  */

                    }
                }, '-', {
                    iconCls: 'icon-remove',
                    text: '删除',
                    handler: function () {
                        alert('删除按钮');

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
</body>
</html>