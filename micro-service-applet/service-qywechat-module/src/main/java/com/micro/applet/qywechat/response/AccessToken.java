package com.micro.applet.qywechat.response;

import java.io.Serializable;

/**
 * 企业微信 access_token
 *
 * 开发者需要缓存access_token，用于后续接口的调用（注意：不能频繁调用gettoken接口，否则会受到频率拦截）。当access_token失效或过期时，需要重新获取。
 *
 * access_token的有效期通过返回的expires_in来传达，正常情况下为7200秒（2小时），有效期内重复获取返回相同结果，过期后获取会返回新的access_token。
 * 由于企业微信每个应用的access_token是彼此独立的，所以进行缓存时需要区分应用来进行存储。
 * access_token至少保留512字节的存储空间。
 * 企业微信可能会出于运营需要，提前使access_token失效，开发者应实现access_token失效时重新获取的逻辑。
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 15:11
 */
public class AccessToken implements Serializable {


    private static final long serialVersionUID = 1L;

    /**出错返回码，为0表示成功，非0表示调用失败*/
    private int errcode;

    /**返回码提示语*/
    private String errmsg;

    /**获取到的凭证，最长为512字节*/
    private String access_token;

    /**凭证的有效时间（秒）正常情况下为7200秒（2小时）*/
    private long expires_in;

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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
