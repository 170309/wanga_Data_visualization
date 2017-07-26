function dataFormatter(obj) {
    var temp;
    var max = 0;
    var min = 0;
    for (var year in obj) {
        temp = obj[year];
        for (var i = 0, l = temp.length; i < l; i++) {
            max = Math.max((temp[i] == '-' ? 0 : temp[i]), max);
            min = Math.min((temp[i] == '-' ? 0 : temp[i]), min);
            obj[year][i] = {
                name: pList[i],
                value: temp[i]
            }
        }
        obj[year + 'max'] = Math.ceil(max / 100) * 100;
        obj[year + 'min'] = Math.floor(min / 100) * 100;
    }
    return obj;
}
var pList = [
    '巴音郭楞蒙古自治州', '哈密地区', '阿克苏地区', '阿勒泰地区', '喀什地区', '昌吉回族自治州', '克孜勒苏柯尔克孜自治州', '吐鲁番地区',
    '博尔塔拉蒙古自治州', '乌鲁木齐市', '克拉玛依市', '图木舒克市', '那曲地区'
];
var dataPeople = dataFormatter({
    2010: [353.8577, 100.0051, -13.6599, 60.5706, 34.0898, 31.8171, 46.6316, 51.7798, 417.7405, 222.1221, 295.8905, -395.5056, 150.0509,5.0799],
    2011: [381.0356, 122.7207, -41.1195, 35.1167, 14.681, 60.6467, 43.4877, 31.1924, 446.9173, 232.2766, 350.5707, -483.4505, 148.8509, 31.8171],
    2012: [416.7532, 150.8626, -88.5592, 0.6556, -8.7474, 66.295, 33.9426, 4.2385, 479.1384, 270.919, 400.6602, -557.7129, 140.3431, 100.0051],
    2013: [462.72, 201.7258, -149.0351, -18.0563, -22.3084, 68.5628, 23.4355, -5.2806, 497.4173, 288.6671, 432.1518, -605.8459, 126.8603, -41.1195],
    2014: [507.4753, 243.3067, -182.5441, -36.09, 5.0799, 85.0265, 20.5115, -18.8419, 809.302, 390.7682, 559.821, -663.5286, 167.3208, 31.8171],
    2015: [700.2997, 309.4373, -104.0499, 100.3752, 18.8034, 123.3245, 23.1861, -9.7859, 890.6798, 402.4096, 699.0459, -868.102, 163.3099, 417.7405],
    2016: [737.6843, 354.6014, -104.2525, 93.4996, 15.7775, 128.0161, 22.8711, -0.315, 928.1013, 384.5499, 681.6868, -918.5812, 168.2389, -395.5056]
});
//console.log(dataPeople);

var option = {
    //color : ["rgb(255,0,0)", "rgb(255,63,0)", "rgb(255,127,0)", "rgb(255,191,0)", "rgb(255,255,0)"],
    title: {
        text: '各地州数据汇总分析',
        subtext: '',
        x: 'center'
    },
    tooltip: {
        trigger: 'item'
    },
    legend: {
        data: [],
        x: 'right',
        y: 55,
        selectedMode: false
    },
    dataRange: {
        color: ['red', 'yellow'],
        text: ['高', '低'], // 文本，默认为数值文本
        calculable: true,
        textStyle: {
        }
    },
    toolbox: {
        show: true,
        orient: 'vertical',
        x: 'right',
        y: 'center',
        feature: {
            mark: {show: true},
            saveAsImage: {show: true}
        }
    },
    grid: {
        x: 700,
        y: 100
    },
    xAxis: [
        {
            type: 'category',
            boundaryGap: false,
            data: function() {
                var list = [];
                for (var i = 1987; i <= 2011; i++) {
                    list.push(i);
                }
                return list;
            }()
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '数值',
            splitArea: {show: true}
        }
    ],
    series: [
        {
            name: 'pm2.5',
            type: 'map',
            mapType: '新疆', //地图类型 china:中国；continent:世界
            mapLocation: {
                x: 'left'
            },
            selectedMode: 'multiple',
            itemStyle: {
                normal: {label: {show: true}},
                emphasis: {
                    label: {show: true},
                    areaStyle: {color: '#eee'}
                }
            },
            hoverable: true, //鼠标经过时，是否高亮显示
            roam: true,
//                    data:XJJson,
            data: [//区域编码是乱写的^_^,为了演示除name和value之外的属性如何取值;
                {name: '巴音郭楞蒙古自治州', value: 623, areaCode: 11111},
                {name: '哈密地区', value: 78, areaCode: 11113},
                {name: '阿克苏地区', value: 384, areaCode: 11114},
                {name: '阿勒泰地区', value: 342, areaCode: 11115},
                {name: '喀什地区', value: 109, areaCode: 11116},
                {name: '昌吉回族自治州', value: 271, areaCode: 11118},
                {name: '克孜勒苏柯尔克孜自治州', value: 98, areaCode: 11119},
                {name: '吐鲁番地区', value: 120, areaCode: 11110},
                {name: '博尔塔拉蒙古自治州', value: 239, areaCode: 11121},
                {name: '乌鲁木齐市', value: 740, areaCode: 11122},
                {name: '克拉玛依市', value: 122, areaCode: 11123},
                {name: '图木舒克市', value: 170, areaCode: 11125},
                {name: '那曲地区', value: 127, areaCode: 11128}
            ],
            itemStyle: {
                normal: {
                    borderColor: '#A1DFF2', //地图边界线颜色
                    borderWidth: 1, //边界线宽度
                    areaStyle: {
                        color: 'orange'
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
                        borderColor: 'orange',
                        borderWidth: 1, // 标注边线线宽，单位px，默认为1
                        label: {
                            show: false
                        }
                    },
                    emphasis: {//地图内图形的强调样式（悬浮时样式）
                        borderColor: '#1e90ff',
                        borderWidth: 5,
                        label: {
                            show: false
                        }
                    }
                },
                data: [
                    {name: "克拉玛依", value: 626, ipAddress: '1.1.1.1'},
                    {name: "乌鲁木齐", value: 855, ipAddress: '22.2.2.2'},
                    {name: "库尔勒", value: 755, ipAddress: '3.3.3.3'},
                    {name: "天山", value: 755, ipAddress: '4.4.4.4'}
                ]
            }
        },
        {//向外发散光圈
            name: 'Top5',
            type: 'map',
            mapType: '新疆',
            data: [],
            markPoint: {
                symbol: 'emptyCircle',
                symbolSize: function(v) {
                    //光圈大小,v代表节点的value值,可改为return 10+v*10/maxRange;
                    return 10 + v / 100
                },
                effect: {
                    show: true,
                    shadowBlur: 0
                },
                itemStyle: {
                    normal: {
                        label: {show: false}
                    }
                },
                tooltip: {//注：此处的tooltip必须放在data参数上面，才能生效
                    formatter: function(param) {
                        return "<b>" + param.data.name + "</b><br/>IP地址：" + param.data.ipAddress + "(" + param.data.value + ")";
                    }
                },
                data: [
                    {name: "克拉玛依", value: 626, ipAddress: '1.1.1.1'},
                    {name: "乌鲁木齐", value: 855, ipAddress: '22.2.2.2'},
                    {name: "库尔勒", value: 755, ipAddress: '3.3.3.3'},
                    {name: "天山", value: 755, ipAddress: '4.4.4.4'}
                ]
            }
        }
    ],
    animation: true
};


// var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
// document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fb78830c9a5dad062d08b90b2bc0cf5da' type='text/javascript'%3E%3C/script%3E"));
