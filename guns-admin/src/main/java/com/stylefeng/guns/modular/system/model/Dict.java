package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author lilei123
 * @since 2018-06-19
 */
@TableName("sys_dict")
public class Dict extends Model<Dict> {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	 * 父id
	 */
	private Integer pid;
	/**
	 * 中文类别
	 */
	private String name;
	/**
	 * 英文类别
	 */
	@TableField("en_name")
	private String enName;
	private String content;
	@TableField("create_date")
	private Date createDate;
	@TableField("update_date")
	private Date updateDate;

	public Dict() {
		super();
	}

	public Dict(Integer id, Integer pid, String name, String enName, String content) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.enName = enName;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Dict [id=" + id + ", pid=" + pid + ", name=" + name + ", enName=" + enName + ", content=" + content
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
}
