// pages/personal/basic/basic.js
const app = getApp();
var config = require('../../../utils/config.js');
var request = require('../../../utils/request.js');
var that = this;

var data =  {
  title:'初始化数据',
  basic:{
    name: '',
    date: "2019-01-01",
    genderItems: [
      { name: '0', value: '男' },
      { name: '1', value: '女' }
    ]
  }
};


Page({

  /**
   * 页面的初始数据
   */
  data: data,
  formSubmit(e) {
    console.log('form发生了submit事件，携带数据为：', e.detail);
    var paras = config.reqPara;
    paras.paras = JSON.stringify(e.detail.value);
    request.ajax({
      url:'/wxCert/saveUserInfo',
      para: paras
    });
    
  },
  /**
   * 日期选择
   */
  bindDateChange: function (e) {
    data.basic.date = e.detail.value;
    this.setData(data)
  },
  /**
   * 性别选择
   */
  radioChange(e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    request.ajax({
      url: '/wxCert/queryUserInfoBySessionId',
      para: {
        sessionId: wx.getStorageSync('sessionId')
      },
      success: function (res) {
        var resData = res.data.data;
        var items = data.basic.genderItems;
        for (var item in items) {
          if (resData.gender == items[item].name) {
            items[item].checked = true;
          }
        }
        data.basic.name = resData.name;
        data.basic.date = resData.birthday;
        data.basic.genderItems = items;
        that.setData(data);
        console.log(res);
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
   
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
     
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
     
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
   
  }

})