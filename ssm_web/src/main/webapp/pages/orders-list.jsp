<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <%@include file="header.jsp"%>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <%@include file="aside.jsp"%>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1> 数据管理
                <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">数据管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">    <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border"><h3 class="box-title">列表</h3></div>
                <div class="box-body">  <!-- 数据表格 -->
                    <div class="table-box">      <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建" onclick="location.href='product-add.html'">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"><i
                                            class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启"><i class="fa fa-check"></i>
                                        开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽"><i class="fa fa-ban"></i>
                                        屏蔽
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"><i
                                            class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback"><input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span></div>
                        </div>               <!--工具栏/-->      <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right: 0px;"><input id="selall" type="checkbox"
                                                                                class="icheckbox_square-blue"></th>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting_desc">订单编号</th>
                                <th class="sorting_asc sorting_asc_disabled">产品名称</th>
                                <th class="sorting_desc sorting_desc_disabled">金额</th>
                                <th class="sorting">下单时间</th>
                                <th class="text-center sorting">订单状态</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="orders">
                                <tr>
                                    <td><input name="ids" type="checkbox"></td>
                                    <td>${orders.id}</td>
                                    <td>${orders.orderNum}</td>
                                    <td>${orders.product.productName}</td>
                                    <td>${orders.product.productPrice}</td>
                                    <td>${orders.orderTimeStr}</td>
                                    <td class="text-center">${orders.orderStatusStr}</td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs">订单</button>
                                        <button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/orders/findById?id=${orders.id}'" >详情</button>
                                        <button type="button" class="btn bg-olive btn-xs" >编辑</button>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                            <!--               <tfoot>               <tr>               <th>Rendering engine</th>               <th>Browser</th>               <th>Platform(s)</th>               <th>Engine version</th>               <th>CSS grade</th>               </tr>               </tfoot>-->
                        </table>               <!--数据列表/-->      <!--工具栏-->
                        <%--<div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"><i
                                            class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"><i
                                            class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启"><i class="fa fa-check"></i>
                                        开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽"><i class="fa fa-ban"></i>
                                        屏蔽
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"><i
                                            class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>--%>
                        <div class="box-tools pull-right">
                            <div class="has-feedback"><input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span></div>
                        </div>
                    </div>
                </div>

                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline"> 总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页
                            <select class="form-control" id="changePageSize">
                                <option <c:if test="${pageInfo.pageSize==1}">selected</c:if> >1</option>
                                <option <c:if test="${pageInfo.pageSize==2}">selected</c:if> >2</option>
                                <option <c:if test="${pageInfo.pageSize==3}">selected</c:if> >3</option>
                                <option <c:if test="${pageInfo.pageSize==4}">selected</c:if> >4</option>
                                <option <c:if test="${pageInfo.pageSize==5}">selected</c:if> >5</option>
                            </select> 条
                        </div>
                    </div>
                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/orders/findByPage?pageNo=1&rows=${pageInfo.pageSize}" aria-label="Previous">首页</a></li>
                            <li><a href="${pageContext.request.contextPath}/orders/findByPage?pageNo=${pageInfo.pageNum-1}&rows=${pageInfo.pageSize}">上一页</a></li>

                            <c:forEach begin="1" end="${pageInfo.pages}" var="num">
                            <li <c:if test="${num == pageInfo.pageNum}">class="active"</c:if>><a href="${pageContext.request.contextPath}/orders/findByPage?pageNo=${num}&rows=${pageInfo.pageSize}">${num}</a></li>
                            </c:forEach>

                            <li><a href="${pageContext.request.contextPath}/orders/findByPage?pageNo=${pageInfo.pageNum+1}&rows=${pageInfo.pageSize}">下一页</a></li>
                            <li><a href="${pageContext.request.contextPath}/orders/findByPage?pageNo=${pageInfo.pages}&rows=${pageInfo.pageSize}" aria-label="Next">尾页</a></li>
                        </ul>
                    </div>
                </div>       <!-- /.box-footer-->
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <%@include file="footer.jsp"%>
    <!-- 底部导航 /-->

</div>


<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>

    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });

        $("#changePageSize").change(function () {
            //1. 获取下拉框选中的值(每页展示的条数)
            var rows = $(this).val();
            //2. 发送请求查询数据
            location.href = "${pageContext.request.contextPath}/orders/findByPage?pageNo=1&rows="+rows
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue', increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>