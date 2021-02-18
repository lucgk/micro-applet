package com.micro.applet.qywechat.response;

import java.io.Serializable;

/**
 * 消息推送响应
 * 如果部分接收人无权限或不存在，发送仍然执行，但会返回无效的部分（即invaliduser或invalidparty或invalidtag），常见的原因是接收人不在应用的可见范围内。
 * 如果全部接收人无权限或不存在，则本次调用返回失败，errcode为81013。
 * 返回包中的userid，不区分大小写，统一转为小写
 * @author liuhui
 * @version 1.0, 2021/2/18 16:18
 */
public class NewPushResp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**出错返回码，为0表示成功，非0表示调用失败*/
    private int errcode;

    /**返回码提示语*/
    private String errmsg;

    private String invaliduser;

    private String invalidparty;

    private String invalidtag;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }

    public String getInvalidtag() {
        return invalidtag;
    }

    public void setInvalidtag(String invalidtag) {
        this.invalidtag = invalidtag;
    }
}
