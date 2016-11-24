<%--
  Created by IntelliJ IDEA.
  User: lw
  Date: 2016/11/17
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/common.jsp" %>
<html>
<head>
    <title></title>

    <script type="text/javascript">
        $(function () {
            $("a[title]").click(function () {//找到title属性的
                var text = this.href;
                if ($("#tt").tabs("exists", this.title)) {
                    alert("存在了");
                } else {
                    $('#tt').tabs('add', {
                        title: this.title,
                        //面板有关闭按键
                        closable: true,
                        //href对远程页面js的支持不好
                        //href: text
                        //可以加载内容填充到选项卡，页面有Js时，也可加载
                        content: "<iframe src='" + text + "' title='" + this.title + "' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                }
                return false; //因为信息是在frame中显示，所以这个地址是不用去的
            });
        })
    </script>

</head>
<body class="easyui-layout">
<!-- 头部 -->
<div data-options="region:'north',title:'欢迎使用进销存管理系统',split:true"
     style="height:130px;">欢迎您 ：${sessionScope.account.accLogin}</div>

<!-- 左边导航 -->
<div data-options="region:'west',title:'导航菜单',split:true"
     style="width:150px;">
    <div id="aa" class="easyui-accordion"
         style="width:300px;height:200px;">
        <div title="基础数据录入">
            <!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
            <ul style="list-style: none;padding: 0px;margin:0px;">
                <li style="padding: 6px;"><a href="${proPath}/base/goURL/supplier/supplierlist.action" title="供应商管理"
                                             style="text-decoration: none;display: block;font-weight:bold;">供应商管理</a>
                </li>
                <li style="padding: 6px;"><a href="${proPath}/base/goURL/goods/goodslist.action" title="商品管理"
                                             style="text-decoration: none;display: block;font-weight:bold;">商品管理</a>
                </li>
            </ul>
        </div>
        <div title="采购管理">
            <!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
            <ul style="list-style: none;padding: 0px;margin:0px;">
                <li style="padding: 6px;"><a href="${proPath}/base/goURL/buyorder/insert.action" title="商品采购"
                                             style="text-decoration: none;display: block;font-weight:bold;">商品采购</a>
                </li>
                <li style="padding: 6px;"><a href="${proPath}/base/goURL/goods/goodslist.action" title="商品退货"
                                             style="text-decoration: none;display: block;font-weight:bold;">商品退货</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- 主体内容 -->
<div data-options="region:'center',title:'主要信息'"
     style="padding:5px;background:#eee;">
    <div id="tt" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">
        <div title="Tab1" style="padding:20px;display:none;">
            tab1
        </div>
    </div>
</div>
<div id="win"></div>
</body>
</html>
