/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  function getTopData(dataJson) {//获取地图数据中的前四
         var topData="[";
         for(var i=0;i<4;i++){
             topData+='{name:"'+dataJson[i].name+'", value: '+dataJson[i].value+"},";
         }
         topData=eval(topData.substring(0,topData.length-1)+"]");
        return topData; 
     }
     
 function getUnmarshallData(dataJson, title) {//折线、条形图数据
        var sData = new Array();
        var aData = new Array();
        for (var i = dataJson.length - 1; i >= 0; i--) {
            sData.push(dataJson[i].value);
            aData.push(dataJson[i].name);
        }
        var barData = {
            "legen": [title],//图例数据标题
            "axis": aData,
            "series": [sData]
        };
        return barData;
    }
function getUnmarshallData2(dataJson) {
        var data=dataJson.data;
        var arr_sum=dataJson.arr_sum;
        
        var sData = new Array();
        var aData = new Array();
        var dataList = new Array(); //数据
        for(var j = 0; j < arr_sum.length; j++){
         for (var i =0 ; i < data.length; i++) {
              if(j===0){
                  aData.push(data[i][arr_sum[j]]);
              }else{ 
              sData.push(data[i][arr_sum[j]]);
              if (sData.length === data.length) {
                    dataList.push(sData);
                    sData = [];
                }
              }
        }
        }
        var barData = {"title": [dataJson.title],//图例数据标题
            "legen":dataJson.legen,
            "axis": aData,
            "series": dataList
        };
        return barData;
    }
    //一周对比图数据解析
    function getUnmarshallData3(dataJson) {
        var data=dataJson.data;
        var arr_sum=dataJson.arr_sum;
        
        var lastWeek = new Array();
        var lastWeek2 = new Array();
        var thisWeek = new Array();
        var devalue = new Array();
        var aData = new Array();
         for (var i =0 ; i < data.length; i++) {
             aData.push(data[i][arr_sum[0]]);
             lastWeek.push(data[i][arr_sum[1]]);
             thisWeek.push(data[i][arr_sum[2]]);
             devalue.push(data[i][arr_sum[3]]);
             if(data[i][arr_sum[1]]>data[i][arr_sum[2]]){
                 lastWeek2.push(data[i][arr_sum[2]]);
             }else{
                 lastWeek2.push(data[i][arr_sum[1]]);
             }
        }
        var barData = {
            "title": [dataJson.title],//图例数据标题
            "legen":dataJson.legen,
            "lastWeek": lastWeek,
            "lastWeek2": lastWeek2,
            "thisWeek": thisWeek,
            "aData": aData,
            "devalue": devalue
        };
        return barData;
    }

// var ma = {
//     "success": true, "title": "木马主控总数", "avgRange": 1000,
//     "data": [{"name": "克拉玛依", "value": 621}, {"name": "哈密", "value": 610}, {"name": "阿克苏", "value": 598},
//         {"name": "阿勒泰", "value": 532}, {"name": "喀什", "value": 432}, {"name": "昌吉州", "value": 377},
//         {"name": "克州", "value": 310}, {"name": "吐鲁番", "value": 317}, {"name": "博州", "value": 271},
//         {"name": "乌鲁木齐市", "value": 270}, {"name": "巴州", "value": 172}, {"name": "塔城", "value": 132}, {
//             "name": "和田",
//             "value": 121
//         }
//     ]
// };
//     function shujufenjie(list) {
//
//         var allsuccess= new Array();
//         var alltitle= new Array();
//         var allavgRange=new Array();
//         var alldataname=new Array();
//         var alldata=new Array();
//         var alldatavalue1=new Array();
//         var alldatavalue2=new Array();
//         var alldatavalue3=new Array();
//         for(var i =0;i<list.length;i++){
//             allsuccess.push(list[i].success);
//             alltitle.push(list[i].title);
//             allavgRange.push(list[i].avgRange);
//             alldata.push(list[i].data);
//             for(var j=0, dataitem=list[i].data;j<dataitem.length;j++){
//                 alldataname.push(dataitem[j].name);
//                 if(i==0){
//                     alldatavalue1.push(dataitem[j].value);
//                 }else if(i==1){
//                     alldatavalue2.push(dataitem[j].value);
//                 }else if(i==2) {
//                     alldatavalue3.push(dataitem[j].value);
//                 }
//             }
//         }
//         var allvalue=new Array();
//         allvalue.push(alldatavalue1,alldatavalue2,alldatavalue3);
//         for(var i = 0;i<alldataname.length;i++){
//             if(alldataname[i] == alldataname[i+1]){
//                 alldataname.splice(i,1);
//             }
//         }
//         var all ={
//             "success":allsuccess,
//             "title":alltitle,
//             "avgrange":allavgRange,
//             "name":alldataname,
//             "data":alldata,
//             "value":allvalue
//         }
//         return all;
//     }



// var ls=["克拉玛依", "哈密", "阿克苏", "阿勒泰", "喀什", "昌吉州", "克州", "吐鲁番", "博州",
//     "乌鲁木齐市", "巴州", "塔城", "和田", "巴州", "昌吉州", "阿克苏", "阿勒泰", "喀什", "哈密",
//     "克州", "吐鲁番", "博州", "乌鲁木齐市", "克拉玛依", "塔城", "和田", "乌鲁木齐市", "吐鲁番",
//     "博州", "阿勒泰", "喀什", "昌吉州", "克州", "哈密", "阿克苏", "克拉玛依", "巴州", "塔城", "和田"];

// function unique1(array){
//     var n=[];//一个新的临时数组
//     for(var i=0;i<array.length;i++){
//         if(n.indexOf(array[i])==-1){
//             n.push(array[i]);
//         }
//     }
//     return n;
// }