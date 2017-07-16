<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
    <div class="container">
        <h2>修改内容</h2>
        <form action="/movie/${id}/edit" method="post">
            <div class="form-group">
                <label>电影名称</label>
                <input type="text" class="form-control" name="title" value="${movie.title}">
            </div>
            <div class="form-group">
                <label>导演</label>
                <input type="text" class="form-control" name="daoyan" value="${movie.daoyan}">
            </div>
            <div class="form-group">
                <label>发行时间</label>
                <input type="text" class="form-control" name="sendtime" value="${movie.releaseyear}">
            </div>
            <div class="form-group">
                <label>上映时间</label>
                <input type="text" class="form-control" name="releaseyear" value="${movie.sendtime}">
            </div>
            <div class="form-group">
                <label>评分</label>
                <input type="text" class="form-control" name="rate" value="${movie.rate}">
            </div>
            <button class="btn btn-primary">确认修改</button>

        </form>
    </div>


</body>
</html>
