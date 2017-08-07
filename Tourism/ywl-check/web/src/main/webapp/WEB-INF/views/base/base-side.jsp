<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 顶部导航栏部分 -->
<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>旅游年票管理</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>凯盛</b>旅游年票管理</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">${sessionScope.curr_user.userName}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <!--<p>
                                ${sessionScope.curr_user.userName}
                                <small>
                                    <c:forEach items="${sessionScope.curr_user.deptList}" var="dept">
                                        ${dept.deptName} &nbsp;&nbsp;
                                    </c:forEach>
                                </small>
                            </p>-->
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/profile" class="btn btn-default btn-flat">个人设置</a>
                            </div>
                            <div class="pull-right">
                                <a href="/logout" class="btn btn-default btn-flat">安全退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>

<!-- =============================================== -->

<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- 搜索表单，不需要删除即可 -->
        <!--<form action="#" method="get" class="sidebar-form">
          <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                  <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                  </button>
                </span>
          </div>
        </form>-->
        <!-- /.search form -->
        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="header">系统功能</li>
            <%--首页--%>
            <li class="${param.active == 'home' ? 'active' : ''}"><a href="/home"><i class="fa fa-home"></i>
                <span>首页</span></a></li>
            <!-- 售票系统 -->
            <li class="treeview ${fn:startsWith(param.active, "customer_") ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-address-book-o"></i> <span>售票系统</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href="/customer/my"><i
                            class="fa fa-circle-o"></i> 年票办理</a></li>
                    <li><a href=#><i class="fa fa-circle-o"></i> 年票续费</a></li>
                    <li><a href=#><i class="fa fa-circle-o"></i> 年票挂失</a></li>
                    <li><a href=#><i class="fa fa-circle-o"></i> 年票解挂</a></li>
                    <li><a href=#><i class="fa fa-circle-o"></i> 年票补办</a></li>
                </ul>
            </li>
            <!-- 景区验票系统 -->
            <li class="treeview ${fn:startsWith(param.active, "sales_") ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-money"></i> <span>景区验票系统</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href=#><i class="fa fa-circle-o"></i> 刷卡信息验证</a></li>
                    <li class=""><a href=#><i class="fa fa-circle-o"></i> 景区验票统计</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- =============================================== -->