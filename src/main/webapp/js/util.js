//
// "use strict";
// var _util={
//     request:function(params){
//         $.ajax({
//             type : params.method  || 'get',
//             url  : params.url     || '',
//             dataType: params.type || 'json',
//             data: params.data     || '',
//             success:function (e) {
//                 typeof e.success === 'function' && e.success(e.data,e.msg);
//             },
//             error:function (e) {
//                 typeof e.success === 'function' && e.error(e.statusText);
//             }
//         });
//
//     }
// };
//
// module.exports = _util;