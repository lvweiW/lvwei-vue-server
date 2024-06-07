package cn.lvwei.vue.server.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long userId;
    /**
     * 用户编号
     */
    private String userNo;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 用户邮箱
     */
    private String userMail;
    /**
     * 密码
     */
    private String password;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标志
     */
    private String deleteFlg;
    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 创建时间
     */
    private Date createDateTime;
    /**
     * 更新人id
     */
    private Long updateUserId;
    /**
     * 更新时间
     */
    private Date updateDateTime;

}