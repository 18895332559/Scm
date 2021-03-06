<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/common.jsp" %>
<html>
<head>


    <title></title>
    <style type="text/css">
        /*.searchbox{*/
        /*margin:-3px;*/
        /*}*/
    </style>

    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                //url:'${proPath}/supplier/selectPage.action', //通过关键字查询
                //支持多条件查询
                //url:'${proPath}/supplier/selectPageUseDyc.action',
                fitColumns: true,
                nowrapL: true,
                idField: 'goodsId',
                rownumbers: true,
                toolbar: [{
                    iconCls: 'icon-add',
                    text: '选择商品',
                    handler: function () {
                        alert('选择商品');
                        parent.$('#win').window({
                            title: '选择需要采购商品',
                            width: 600,
                            height: 400,
                            modal: true,
                            content: "<iframe src='${proPath}/base/goURL/goods/select.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                        });
                    }
                }, '-', {
                    iconCls: 'icon-remove',
                    text: '删除商品',
                    handler: function () {
                        alert('删除商品');
                        //判断是否选中一行，并且只能选中一行进行修改
                        var array = $("#dg").datagrid("getSelections");
                        if (array.length > 0) {
                            for (var i = array.length - 1; i >= 0; i--) {
                                alert(i);
                                var index = $("#dg").datagrid("getRowIndex", array[i].goodsId);
                                $("#dg").datagrid("deleteRow", index);
                            }

                        } else {
                            alert("请选择不需要采购的商品");
                        }

                    }
                }, '-', {
                    iconCls: 'icon-ok',
                    text: '提交采购',
                    handler: function () {
                        alert('提交采购');
                        //获取要提交的数据
                        var rows = $("#dg").datagrid("getRows");
                        console.info(rows);
                        //把对象转成JSON格式的字符串
                        rows = JSON.stringify(rows);
                        console.info(rows);
                        alert(rows);
                        var proth = "${proPath}";
                        alert("proth:" + proth);
                        //将要采购的数据提交到服务器
                        //注意：这个是get提交
                        /*  $("#ff").form("submit", {
                         url: "
                        ${proPath}/buyOrder/insert.action",
                         onSubmit: function (param) {
                         param.rows = rows;
                         return true;
                         },
                         success: function (data) {
                         //自己处理返回的信息
                         alert(data);
                         }
                         });*/
                        //提交采购到服务端
                        $('#ff').form('submit', {
                            url: ' ${proPath}/buyOrder/insert.action',
                            onSubmit: function (param) {
                                param.rows = rows;
                                return true;
                            },
                            success: function (data) {
                                //自己处理返回的信息
                                alert(data);
                            }
                        });
                    }

                }],

                columns: [[{
                    checkbox: true
                }, {
                    field: 'goodsId',
                    title: '商品编号',
                    width: 100
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
                }, {
                    field: 'bodAmount',
                    title: '数量',
                    width: 100
                }, {
                    field: 'bodBuyPrice',
                    title: '进价',
                    width: 100
                }, {
                    field: 'bodTotalPrice',
                    title: '合计',
                    width: 100
                }, {
                    field: 'bodImeiList',
                    title: '串号列表',
                    width: 100,
                    align: 'right'
                }]]
            });

            //让供应商输入框只读
            $("#supName").attr("readonly",true);

            //使用供应商查询
            $('#supName').searchbox({
                searcher: function (value, name) {
                    //alert(value + "," + name);
                    parent.$('#win').window({
                        title: '选择供应商',
                        width: 800,
                        height: 600,
                        modal: true,
                        content: "<iframe src='${proPath}/base/goURL/supplier/select.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });

                },
                prompt: '请选择供应商'
            });
        });
    </script>
</head>

<body>
<form style="padding:15px;margin:0px;background:#eee;" id="ff" action="">
    请填写采购信息：<br>
    供应商：<input type="hidden" id="supId" name="supId"/>
    <input type="text" id="supName" name="supName" />
    仓库：<input type="text" id="shId" name="shId"/>
    日期：<input type="text" id="boDate"
              class="easyui-datebox" name="boDate" required="required"/>

    应付：<input type="text" id="boPayable" name="boPayable"/><br>
    已付：<input type="text" id="boPaid" name="boPaid"/>
    欠款：<input type="text" id="boArrears" name="boArrears"/>
    原始单号：<input type="text" id="boOriginal" name="boOriginal"/><br>
    经手人：<input type="text" id="boAttn" name="boAttn"/>
    操作员：<input type="text" id="boOperator" name="boOperator"/>
    备注：<input type="text" id="boRemark" name="boRemark"/>
</form>

<table id="dg"></table>
</body>
</html>