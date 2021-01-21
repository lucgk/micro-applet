package com.micro.applet.system.entity;

import java.util.Date;

public class RoleInfo {
    /**
     *主键id
     */
    private Long id;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *修改时间
     */
    private Date updateTime;

    /**
     *是否删除 0 否 1 是
     */
    private Byte delFlag;

    /**
     *角色名称
     */
    private String rolename;

    /**
     *角色CODE
     */
    private String rolecode;

    /**
     *主键id
     */
    public Long getId() {
        return id;
    }

    /**
     *主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *是否删除 0 否 1 是
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     *是否删除 0 否 1 是
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     *角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     *角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     *角色CODE
     */
    public String getRolecode() {
        return rolecode;
    }

    /**
     *角色CODE
     */
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }
}