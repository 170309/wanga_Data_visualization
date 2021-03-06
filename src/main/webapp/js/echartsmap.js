// var ma = {
//     "success": true, "title": "木马受控端数量", "avgRange": 2000,
//     "data": [
//         {"name": "乌鲁木齐市", "value": 16956},
//         {"name": "喀什", "value": 6019},
//         {"name": "阿克苏", "value": 5229},
//         {"name": "伊犁州", "value": 4792},
//         {"name": "哈密", "value": 3038},
//         {"name": "昌吉州", "value": 2969},
//         {"name": "巴州", "value": 1887},
//         {"name": "克拉玛依", "value": 1683},
//         {"name": "博州", "value": 634},
//         {"name": "吐鲁番", "value": 535},
//         {"name": "塔城", "value": 360},
//         {"name": "阿勒泰", "value": 138},
//         {"name": "和田", "value": 97},
//         {"name": "石河子", "value": 89},
//         {"name": "克州", "value": 33}
//     ]
// };
// var kzrc = {
//     "success": true, "title": "蠕虫病毒感染数量", "avgRange": 1000,
//     "data": [
//         {"name": "乌鲁木齐市", "value": 1074},
//         {"name": "巴州", "value": 262},
//         {"name": "伊犁州", "value": 235},
//         {"name": "克拉玛依", "value": 141},
//         {"name": "克州", "value": 139},
//         {"name": "昌吉州", "value": 128},
//         {"name": "阿克苏", "value": 107},
//         {"name": "石河子", "value": 72},
//         {"name": "博州", "value": 60},
//         {"name": "喀什", "value": 55},
//         {"name": "阿勒泰", "value": 48},
//         {"name": "吐鲁番", "value": 47},
//         {"name": "哈密", "value": 44},
//         {"name": "塔城", "value": 32},
//         {"name": "和田", "value": 23}
//     ]
// };
// var skrc = {
//     "success": true, "title": "木马控制端数量", "avgRange": 1000,
//     "data": [
//         {"name": "乌鲁木齐市", "value": 15},
//         {"name": "吐鲁番", "value": 242},
//         {"name": "昌吉州", "value": 1},
//         {"name": "石河子", "value": 2}
//     ]
// };

// var varList = [ma, kzrc, skrc];
var varList = [];

   $.ajax({
       url: '/mmall/data/get_data_1.do',
       dataType: 'json',
//            async:false,
       success: function (res) {
           var mmsk = {
               title: res.data.consoledtitle,
               data: res.data.consoled,
               avgRange: 2000
           };
           console.log(mmsk);
           formmaterResponse(res);
           getData();
           setInterval('getData()', groupIntervalTime);
       }
   });


   function formmaterResponse(res) {
       var mmsk = {
           title: res.data.consoledtitle,
           data: res.data.consoled,
           avgRange: 2000
       };
       var worm = {
           title: res.data.wormtitle,
           data: res.data.worm,
           avgRange: 2000
       }

        varList = [mmsk, worm];
       // console.log(varList);

//        setInterval(_getData(varList), groupIntervalTime);
   }


// getData();
// setInterval('getData()', groupIntervalTime);

function _getData(args) {
    return function () {
        getData(args);
    }
}

function getData() {
    var i = 0;
    if (i === 0) {
        DrawMap(eval(varList[i].data), varList[i].title, varList[i].avgRange);//绘图
        Unmarshalling(getUnmarshallData(varList[i].data, varList[i].title));//
        var interval = setInterval(function () {
            ++i;
            DrawMap(eval(varList[i].data), varList[i].title, varList[i].avgRange);
            Unmarshalling(getUnmarshallData(varList[i].data, varList[i].title));
            if (i === (parseInt(varList.length - 1))) {
                clearInterval(interval);
                return;
            }
        }, intervalTime);
    }

}

function DrawMap(dataJson, mapTitle, maxRange) {
    var topData = getTopData(dataJson, 'name', 'value');
    require.config({
        paths: {
            echarts: 'js/echarts/graph'
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/map'
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById("mapContainer"));
            var option = {
                title: {
                    text: mapTitle,
                    x: '600'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: function (param) {//提示信息格式化
                        return "<b>" + param.data.name + "</b><br/>数量：" + param.data.value;
                    }
                },
                legend: {
                    orient: 'vertical', //图例位置2
                    x: 'left',
                    data: ['']//图例文本信息
                },
                dataRange: {
                    min: 0, //值域控件最小值
                    max: maxRange, //值域控件最大值
                    calculable: true, //默认为false,设置为true时值域显示为线性渐变
                    precision: 0, //小数精度，默认为0
                    color: ['#FF5151', '#ff7575', '#FF9797', '#FFB5B5']//值域颜色，最少两个
                },
                toolbox: {//图表工具
                    show: true, //是否展示
                    //布局方式，默认为水平布局，水平(vertical)|垂直(horizontal)
                    orient: 'vertical',
                    //横向位置，可选为：'center' | 'left' | 'right' | {number}(x坐标，单位px)
                    x: '25',
                    //纵向位置可选为：'top' | 'bottom' | 'center' | {number}(y坐标，单位px)
                    y: 'top',
                    feature: {
                        saveAsImage: {show: true}	//保存为图片
                    }
                },
                series: [
                    {
                        type: 'map',
                        mapType: '新疆', //地图类型 china:中国；continent:世界
                        hoverable: true, //鼠标经过时，是否高亮显示
                        roam: true,
                        data: dataJson,
                        itemStyle: {//地图底色
                            normal: {
                                borderColor: '#A1DFF2', //地图边界线颜色
                                borderWidth: 1, //边界线宽度
                                areaStyle: {
                                    color: '#fff'
                                },
                                label: {
                                    show: true
                                }
                            }
                        },
                        geoCoord: geoCoord	//地区经纬度
                    },
                    {//坐标标注
                        type: 'map',
                        mapType: '新疆',
                        data: [],
                        markPoint: {
                            // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
                            symbolSize: 5,
                            itemStyle: {
                                normal: {//地图内图形的默认样式和强调样式（悬浮时样式）
                                    borderColor: 'red',
                                    borderWidth: 1, // 标注边线线宽，单位px，默认为1
                                    label: {
                                        show: false
                                    }
                                },
                                emphasis: {//地图内图形的强调样式（悬浮时样式）
                                    borderColor: 'red',
                                    borderWidth: 5,
                                    label: {
                                        show: false
                                    }
                                }
                            },
                            data: topData
                        }
                    },
                    {//向外发散光圈
                        name: 'Top5',
                        type: 'map',
                        mapType: '新疆',
                        data: [],
                        markPoint: {
                            symbol: 'emptyCircle',
                            symbolSize: function (v) {
                                //光圈大小,v代表节点的value值,可改为return 10+v*10/maxRange;
                                return 10 + v * 10 / maxRange;
                            },
                            effect: {
                                show: true,
                                shadowBlur: 0
                            },
                            itemStyle: {
                                normal: {
                                    borderColor: 'red',
                                    label: {show: false}
                                }
                            },
                            tooltip: {//注：此处的tooltip必须放在data参数上面，才能生效
                                formatter: function (param) {
                                    return "<b>" + param.data.name + "</b><br/>(" + param.data.value + ")";
                                }
                            },
                            data: topData
                        }
                    }
                ]
            };
            myChart.setOption(option);
        }
    );
}

function Unmarshalling(data) {
    var legendData = [];
    var xAxisData = [];
    var seriesData = [];
    if (data !== null && data["series"].length > 0) {
        legendData = data["legen"];
        xAxisData = data["axis"];
        for (var i = 0, len = data["series"].length; i < len; i++) {
            seriesData.push({
                "name": legendData[i],
                "type": "bar",
                "data": data["series"][i],
                itemStyle: {
                    normal: {
//                                    color: 'lightgreen',
                        label: {
                            show: true,
                            textStyle: {
                                color: '#800080'
                            }
                        }
                    }
                }
            });
        }
    }
    require.config({
        paths: {
            echarts: 'js/echarts/graph' //引用资源文件夹路径，注意路径
        }
    });
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line'
        ],
        function (ec) {
            // 找到div容器，初始化echarts图表
            var myChart = ec.init(document.getElementById("pieChart"));
            var option = {
                title: {
                    text: '',
                    subtext: ''
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: legendData
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['bar', 'line']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'value',
                        boundaryGap: [0, 0.01],
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            textStyle: {
                                fontFamily: 'verdana'
                            }
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'category',
                        data: xAxisData,
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            textStyle: {
                                fontFamily: 'verdana'
                            }
                        }
                    }
                ],
                series: seriesData
            };
            myChart.setOption(option);
        }
    );

}
