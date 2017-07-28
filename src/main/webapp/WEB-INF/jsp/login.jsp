<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel=stylesheet type='text/css' href="css/common.css"/>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <title></title>
</head>
<body>

<div class="login-con">
    <div class="login-content">
        <div class="input-group margin-bottom">
            <span class="input-group-addon" style="padding: 0 5px" id="sizing-addon1">用户名：</span>
            <input type="text" id="username" class="form-control" placeholder="请输入用户名" aria-describedby="sizing-addon1">
        </div>
        <div class="input-group margin-bottom">
            <span class="input-group-addon" style="padding: 0 10px" id="sizing-addon1">密  码：</span>
            <input type="password" id="password" class="form-control" placeholder="请输入密码"
                   aria-describedby="sizing-addon1">
        </div>
        <div class="center">
            <button id="submit"  class="btn btn-default" style="padding: 5px 20px">登&nbsp;&nbsp;&nbsp;录
            </button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    $(document).ready(function(){

        var fetch = function () {
            var username = $('#username').val().trim();
            var password = $('#password').val().trim();
            $.ajax({
                type: 'post',
                url: '/user/login.do',
                data: {
                    name: username ,
                    password: password
                },
                success: function (res) {
                    if(res.success){
                        $.ajax({
                            type:'get',
                            url: '/redirect',
                            success:function (res) {
                                document.write(res);
                            }
                        })
                    }else{
                        alert("密码错误");
                    }
                },
                error: function (errmsg) {
                    alert("error");
                }
            });
        };
        $("#submit").click(function(){  //如果是<a class="one">点击</a>,把"#one"改成".one"
            fetch();
        });
        $("body").keydown(function (e) {
            if(e.keyCode == "13"){
                $("#submit").click();
            }
        });
    });



</script>
</html>