<%@page contentType="text/html" pageEncoding="UTF-8"%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>网安数据汇总分析</title>

        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link type="text/css" rel="stylesheet" href="js/jquery-ui.css"/>

        <link rel=stylesheet  type='text/css'href="css/jquery-ui-1.8.5.custom.css" media="all"/>
        <link rel=stylesheet type='text/css'href="css/load-styles.css"media="all"/>
        <link rel=stylesheet type='text/css'href="css/colors-classic.css"media="all"/>

        <link href="js/echarts/css/font-awesome.min.css" rel="stylesheet">
        <link href="js/echarts/css/bootstrap.css" rel="stylesheet">
        <link href="js/echarts/css/carousel.css" rel="stylesheet">
        <link href="js/echarts/css/echartsHome.css" rel="stylesheet">
        <link href="js/echarts/css/codemirror.css" rel="stylesheet">
        <link href="js/echarts/css/monokai.css" rel="stylesheet">

        <script src="js/echarts/echartsHome.js" type="text/javascript"></script>
        <script src="js/echarts/bootstrap.min.js" type="text/javascript"></script>	
        <script src="js/echarts/codemirror.js" type="text/javascript"></script>
        <script src="js/echarts/javascript.js" type="text/javascript"></script>
        <script src="js/echarts/echartsConfig.js" type="text/javascript"></script>
        <script src="js/echarts/www/echarts.js" type="text/javascript"></script>
        <script src="js/echarts/www/chart/geoCoord.js" type="text/javascript"></script>
        <script src="js/echarts/data-people.js" type="text/javascript"></script>

        <style type="text/css">
            .tab_nosid td{
                border-bottom:dashed #CCC 1px;
            }
        </style>
        <!--自定义-->
        <style type="text/css"   >
            #adminmenu LI.wp-has-current-submenu .wp-menu-toggle {
                BACKGROUND: url('img/menu-bits-vs.gif') no-repeat left -207px;
            }
            ol{
                /*counter-reset: li;*/
                list-style: none;
                /*list-style: decimal;*/
                font: 15px 'trebuchet MS', 'lucida sans';
                padding: 0;
                margin-bottom: 4em;
                text-shadow: 0 1px 0 rgba(255,255,255,.5);
            }
            ol ol{
                margin: 0 0 0 2em;
            }
            .rectangle-list div{
                position: relative;
                display: block;
                padding: .4em .4em .4em .8em;
                *padding: .4em;
                margin: .5em 0 .5em 2.5em;
                background: #F0F0F0;
                color: #444;
                text-decoration: none;
                -webkit-transition: all .3s ease-out;
                -moz-transition: all .3s ease-out;
                -ms-transition: all .3s ease-out;
                -o-transition: all .3s ease-out;
                transition: all .3s ease-out;	
            }

            .rectangle-list div:hover{
                background: #eee;
            }	

/*            .scroll div:before{ 
                counter-increment: li;
                content: counter(li);
                position: absolute;	
                left: -2.5em;
                top: 50%;
                margin-top: -1em;
                background: #A1DFF2;
                height: 2em;
                width: 2em;
                line-height: 2em;
                text-align: center;
                font-weight: bold;
            }

            .rectangle-list div:after{
                position: absolute;	
                content: '';
                border: .5em solid transparent;
                left: -1em;
                top: 50%;
                margin-top: -.5em;
                -webkit-transition: all .3s ease-out;
                -moz-transition: all .3s ease-out;
                -ms-transition: all .3s ease-out;
                -o-transition: all .3s ease-out;
                transition: all .3s ease-out;				
            }

            .rectangle-list div:hover:after{
                left: -.5em;
                border-left-color: #A1DFF2;				
            }*/
           .rectangle-list,li{list-style:none; margin:0; padding:0;}  

           .scroll{ position:relative;z-index:5;height:100%;padding-right:0.5em;width:40%;float:right;overflow:hidden;}  

           .scroll li{ width:500px; height:45px; line-height:30px; overflow:hidden;font-weight:bolder}  
        </style>
        <!--样式表-->
    </head>
    <body  class="wp-admin no-js">
        <div id="wpwrap">
            <div id="wpcontent">
                <div id="wpbody" >
                    <ul id="adminmenu" >
                        <div  id="YH">
                            <li id="UUE"   class="wp-has-submenu  wp-has-current-submenu   menu-top menu-icon-users"> 
                                <div class="wp-menu-image"><a href="#"><BR></a></div>   
                                <div class="wp-menu-toggle"><BR></div>
                                <a class="wp-has-submenu wp-has-current-submenu  menu-top menu-icon-post menu-top-first" tabIndex=1 href="#">统计图</a>
                                <div style="background:#3c6b95">
                                    <div class="wp-submenu-head">统计图</div>
                                    <UL>
                                        <li class="wp-first-item">
                                            <a class="wp-first-item "tabIndex=1  href="#" onclick="loadpage('echartsMap');"><font style="color: #FFF;font-weight: bold;">全疆地域分析图</font></a>
                                        </li>
<!--                                        <li class="wp-first-item">
                                            <a class="wp-first-item "tabIndex=1  href="#" onclick="loadpage('echartsMap_chart');"><font style="color: #FFF;font-weight: bold;">条形图</font></a>
                                        </li>-->
                                    </UL>
                                </div>
                            </li>
                        </div>
                        <li  style="display:block;" class="wp-menu-separator"><a class="separator" href="#"><BR></a></li>
                    </ul> <!--menu-->
                    <div id="wpbody-content">
                        <div class="wrap"   >
                            <div class="postbox-container" style="width:99%;">
                                <div id="poststuff" class="metabox-holder" >
                                    <div id="post-body"><div id=post-body-content>
                                            <div id="advanced-sortables" class="meta-box-sortables">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div></div><!-- wpbody-content -->
                    <div class="clear"></div></div><!-- wpbody -->
                <div class="clear"></div></div><!-- wpcontent -->
        </div><!-- wpwrap -->

        <div id="manageTestsHelp" style="display: none"></div>

        <div id="stepwindow" style="display:block;"></div>
<!--        <div id=footer>
            <p id=footer-left class=alignleft><span id=footer-thankyou>感谢使用</span> |<a href="mailto:lxxjnzy@sina.com">反馈</a></p>
            <p id=footer-upgrade class=alignright> v1.0 版本</p>
            <div class=clear></div></div>-->
        <div class="" style="display: none;" id="postBox" >
            <input type="hidden" id="loginUserIsRight" value=${sessionScope.user.isRight} />
            <input type="hidden" id="loginUserUserID" value=${sessionScope.user.userID} />
        </div>
    </body>
</html>

<SCRIPT type="text/javascript">
    $(".wp-menu-toggle").bind("click", function() {
        $(this).next().next().slideToggle("slow", '');
    });

    $(".wp-menu-separator").bind("click", function() {

        $("#wpcontent").toggleClass("folded");
        if ($("#wpcontent").hasClass("folded")) {
            $(".wp-menu-image").bind("mouseover", function() {
                $(this).next().next().next().show();
            });

            $(".wp-submenu").bind("mouseleave", function() {
                $(this).hide();
            });
        } else {
            $(".wp-menu-image").unbind("mouseover");
            $(".wp-submenu").unbind("mouseleave");

        }
    });
    function loadpage(n) {
        $("#" + n).remove();
        $("#advanced-sortables").empty();
        $("#advanced-sortables").load("template/" + n + ".html")
    }
    function postBoxCloseMe(t) {
        $("#" + t).remove();
    }
</SCRIPT>
