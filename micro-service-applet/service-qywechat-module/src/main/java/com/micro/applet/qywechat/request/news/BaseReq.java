package com.micro.applet.qywechat.request.news;

import java.io.Serializable;

/**
 * 消息推送 公共实体
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 16:00
 */
public class BaseReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 指定接收消息的成员，成员ID列表（多个接收者用‘|’分隔，最多支持1000个）。
     * 特殊情况：指定为”@all”，则向该企业应用的全部成员发送
     **/
    private String touser;
    
    /**
     * 指定接收消息的部门，部门ID列表，多个接收者用‘|’分隔，最多支持100个。
     * 当touser为”@all”时忽略本参数
     **/
    private String toparty;
    
    /**
     * 指定接收消息的标签，标签ID列表，多个接收者用‘|’分隔，最多支持100个。
     * 当touser为”@all”时忽略本参数
     **/
    private String totag;

    /**
     * 企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
     **/
    private int agentid;

    /**
     * 表示是否开启重复消息检查，0表示否，1表示是，默认0
     **/
    private int enable_duplicate_check = 0 ;

    /**
     * 表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
     **/
    private long duplicate_check_interval=1800;


    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public int getEnable_duplicate_check() {
        return enable_duplicate_check;
    }

    public void setEnable_duplicate_check(int enable_duplicate_check) {
        this.enable_duplicate_check = enable_duplicate_check;
    }

    public long getDuplicate_check_interval() {
        return duplicate_check_interval;
    }

    public void setDuplicate_check_interval(long duplicate_check_interval) {
        this.duplicate_check_interval = duplicate_check_interval;
    }
}
