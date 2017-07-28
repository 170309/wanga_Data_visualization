<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>网安数据汇总分析</title>

        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link rel=stylesheet type='text/css' href="css/load-styles.css" media="all"/>
        <link rel=stylesheet type='text/css' href="css/colors-classic.css" media="all"/>
        <link rel=stylesheet type='text/css' href="css/menyDemo.css" media="all"/>
        <link rel=stylesheet type='text/css' href="css/indexStyle.css" media="all"/>
        <link rel=stylesheet type='text/css' href="css/common.css" />

        <link href="js/echarts/css/font-awesome.min.css" rel="stylesheet">
        <link href="js/echarts/css/bootstrap.css" rel="stylesheet">
        <link href="js/echarts/css/carousel.css" rel="stylesheet">
        <link href="js/echarts/css/echartsHome.css" rel="stylesheet">
        <link href="js/echarts/css/codemirror.css" rel="stylesheet">
        <link href="js/echarts/css/monokai.css" rel="stylesheet">


        <script src="js/meny.js" type="text/javascript"></script>
        <script src="js/echarts/codemirror.js" type="text/javascript"></script>
        <script src="js/echarts/javascript.js" type="text/javascript"></script>
        <script src="js/echarts/echartsConfig.js" type="text/javascript"></script>
        <script src="js/echarts/graph/echarts.js" type="text/javascript"></script>
        <script src="js/echarts/graph/chart/geoCoord.js" type="text/javascript"></script>
        <script src="js/echarts/data-people.js" type="text/javascript"></script>
        <script src="js/echartJson.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body  class="wp-admin no-js" >
        <div id="wpwrap"> 
            <div id="wpcontent">
                <div id="wa_title" style='position:fixed; z-index:999; top:0;'>
                    <!--<center><strong> CNCERT新疆分中心-网安数据汇总分析</strong>-->
                    <center><strong> 新疆网安数据态势分析</strong>
                        <div id="time4" style='float:right'></div>
                    </center>
                </div>

                <div id="wpbody">
                    <!--嵌套开始-->
                    <div class="meny">
                        <h2>功能菜单</h2>
                        <ul>
                            <li><a class="menu-item" onclick="loadpage('echartsMap');" >大屏页面</a></li>
                            <li><a class="menu-item" onclick="loadpage('WAIndex');" >首页</a></li>
                            <li><a class="menu-item" onclick="loadpage('individualHtml');" >某单位</a></li>
                        </ul>
                    </div>

                    <div class="meny-arrow"></div>
                    <div class="contents" >
                        <DIV class="meta-box-sortables" id="advanced-sortables">

                        </div>
                    </div>

                    <!--嵌套结束-->	
                </div><!-- wpbody -->
            </div><!-- wpcontent -->
        </div><!-- wpwrap -->
        <input type="hidden" id="setTypeVirus"/>
    </body>
</html>

<SCRIPT type="text/javascript">
    var meny = Meny.create({
        menuElement: document.querySelector('.meny'),
        contentsElement: document.querySelector('.contents'),
        position: Meny.getQuery().p || 'left',
        height: 200,
        width: 260,
        threshold: 40,
        mouse: true,
        touch: true
    });
    if (Meny.getQuery().u && Meny.getQuery().u.match(/^http/gi)) {
        var contents = document.querySelector('.contents');
        contents.style.padding = '0px';
        contents.innerHTML = '<div class="cover"></div><iframe src="' + Meny.getQuery().u + '" style="width: 100%; height: 100%; border: 0; position: absolute;"></iframe>';
    }
    showTime();
    loadpage("echartsMap");
    function loadpage(n) {
        $("#" + n).remove();
        $("#advanced-sortables").empty();
        $("#advanced-sortables").load("template/" + n + ".html");

    }
    function loadpageByTitle(n, title) {
        $("#" + n).remove();
        $("#advanced-sortables").empty();
        $("#advanced-sortables").load("template/" + n + ".html", function() {
            if (title !== null || title.length !== 0) {
                $("#setTypeVirus").val(title);
            }
        });
    }
    function postBoxCloseMe(t) {
        $("#" + t).remove();
    }
    function showTime() {
        var dateTime = new Date();
        var hh = dateTime.getHours();
        var mm = dateTime.getMinutes();
        var ss = dateTime.getSeconds();
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (ss < 10) {
            ss = "0" + ss;
        }
        var yy = dateTime.getFullYear();
        var MM = dateTime.getMonth() + 1;
        var dd = dateTime.getDate();
        var week = dateTime.getDay();
        var days = ["日 ", "一 ", "二 ", "三 ", "四 ", "五 ", "六 "];
        document.getElementById("time4").innerHTML = yy + "年" + MM + "月" + dd + "日 " + "星期" + days[week] + hh + ":" + mm + ":" + ss;
        setTimeout(showTime, 1000);
    }
</SCRIPT>
