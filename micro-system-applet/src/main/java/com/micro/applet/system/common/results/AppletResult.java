package com.micro.applet.system.common.results;

import com.micro.applet.system.common.constants.CommonConstans;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * applet 通用响应封装
 *
 * @author liuhui
 * @version 1.0, 2021/1/29 14:49
 */
public class AppletResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应描述
     */
    private String msg;

    /**
     * 数据
     **/
    private Object datas;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    private AppletResult(){}


    public static AppletResult success(){
        AppletResult instant = new AppletResult();
        instant.msg = CommonConstans.FLAG_SUCCESS;
        instant.code = HttpStatus.OK.value();
        return instant;
    }

    public static AppletResult successWithDatas(Object datas){
        return success().withDatas(datas);
    }

    public static AppletResult fail(){
        AppletResult instant = new AppletResult();
        instant.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return instant;
    }

    public static AppletResult failWithMsg(String msg){
        return fail().withMsg(msg);
    }

    private AppletResult withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    private AppletResult withDatas(Object datas) {
        this.datas = datas;
        return this;
    }


}
