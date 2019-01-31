var config = require('config.js');
module.exports = {
  ajax : ajax,
  ajaxFun : fun_ajax,
  postReq : postReq,
  getReq : getReq
}


function ajax(obj){
  if(null==obj.method){
      obj.method = 'POST';
  }
  if(null == obj.header){
    obj.header = {
      'content-type': 'application/x-www-form-urlencoded' // 默认值
    }
  }
  if(null == obj.success){
    obj.success = function(res) {
      var rs = res.data;
      if (rs.isOk) {
        console.log(res);
        wx.showToast({
          title: '操作成功',
          icon: 'success',
          duration: 3000
        });
      } else {
        wx.showModal({
          content: rs.msg,
          showCancel: false
        });
      }
    }
  }

  if(null == obj.error){
    obj.error = function(res) {
      wx.showModal({
        content: rs.msg,
        showCancel: false
      });
    }
  }
  wx.request({
    method: obj.method,
    url: config.getHost + obj.url, // 仅为示例，并非真实的接口地址
    data: obj.para,
    header: obj.header,
    success: obj.success,
    error: obj.error
  });

}


/**
 * method : 请求方式 GET / POST
 * url    : restful url
 * para   :  paras 
 * successCallback : 成功回调
 * errorCallback   : 失败回调
 */
function fun_ajax(method,url,para,successCallback,errorCallback){
  wx.request({
    method: method,
    url: config.getHost + url, // 仅为示例，并非真实的接口地址
    data:para,
    header: {
      'content-type': 'application/x-www-form-urlencoded'
      //'content-type': 'application/json' // 默认值
    },
    success(res) {
      //  console.log(res.data)
      if(res.statusCode==200){
          return successCallback(res);
          // successCallback(res);
      }else{
          return errorCallback(res);
      }
    },
    error:function(xhr,type,status){
        // console.log(xhr,type,status);
      // return errorCallback && errorCallback(res);
      return  errorCallback(res);
    }
  });
}

function getReq(url, para, successCallback, errorCallback){
  fun_ajax('GET',url, para, successCallback, errorCallback);
}

function postReq(url, para, successCallback, errorCallback) {
  fun_ajax('POST', url, para, successCallback, errorCallback);
}
