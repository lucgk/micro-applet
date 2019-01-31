//对外提供接口  需要暴露在外面才能调用
module.exports = {
  getHost: 'http://localhost:3032/space',//host接口
  getCode: getCode,
  reqPara: {
    sessionId: wx.getStorageSync('sessionId'),
    reqDesc: '微信applet 请求',
    paras : ''
  }
}

//获取登录code
function getCode(){
  
}