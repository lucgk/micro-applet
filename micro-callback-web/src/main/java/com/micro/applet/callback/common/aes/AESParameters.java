package com.micro.applet.callback.common.aes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AES 加密参数
 *
 * @author liuhui
 * @version 1.0, 2021/3/19 16:20
 */
@ApiModel("AESParameters AES加密参数")
public class AESParameters {

    @ApiModelProperty(value = "消息加解密 Key : 公众平台上，开发者设置的EncodingAESKey", example = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG",required = true)
    private String encodingAesKey;

    @ApiModelProperty(value = "公众平台上，开发者设置的token",example = "pamtest",required = true)
    private String token;

    @ApiModelProperty(value = "公众平台appid",example = "wxb11529c136998cb6",required = true)
    private String appId;

    @ApiModelProperty(value = "时间戳，可以自己生成，也可以用URL参数的timestamp。 单位s",example = "1409304348",required = true)
    private String timestamp;

    @ApiModelProperty(value = "随机字符串，可以自己生成，也可以用URL参数的nonce",example = "xxxxxx")
    private String nonce;

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
