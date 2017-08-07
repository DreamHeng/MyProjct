<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>凯盛软件CRM-首页</title>
    <%@ include file="../base/base-css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/tree/css/metroStyle/metroStyle.css">
    <link rel="stylesheet" href="/static/plugins/datatables/dataTables.bootstrap.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <!-- JSP动作 -->
    <jsp:include page="../base/base-side.jsp">
        <jsp:param name="active" value="check"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">刷卡信息验证</h3>
                    <div class="box-tools pull-right">
                        <a href="/home" class="btn btn-primary btn-sm"><i class="fa fa-arrow-left"></i> 返回首页</a>
                    </div>
                </div>
                <div class="box-body">
                    <form id="verifyForm" method="post">
                        <div class="form-group">
                            <label>年票编号</label>
                            <input type="text" class="form-control" name="annualId">
                        </div>
                        <div class="form-group">
                            <label>景区Id</label>
                            <input type="text" class="form-control" name="placeId">
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn btn-primary" id="verifyBtn">提交</button>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <%@ include file="../base/base-footer.jsp"%>

</div>
<!-- ./wrapper -->

<%@include file="../base/base-js.jsp"%>
<script src="/static/plugins/validate/jquery.validate.js"></script>
<script>
    $(function () {
        $("#verifyBtn").click(function () {
            $("#verifyForm").submit();
        });
        $("#verifyForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                annualId:{
                    required:true
                },
                placeId:{
                    placeId:true
                }
            },
            messages:{
                annualId:{
                    required:"请输入年票编号"
                },
                placeId:{
                    required:"请输入景区Id"
                }

            },
            submitHandler:function(){
                $.post("/check",$("#verifyBtn").serialize()).done(function(data){
                    if(data.state == "success") {
                        layer.alert("验票通过",function(){
                            window.location.href = "/";
                        });
                    } else {
                        layer.msg(data.message);
                    }
                }).error(function(){
                    layer.msg("服务器异常");
                });
            }
        });
    });
</script>

</body>
</html>
