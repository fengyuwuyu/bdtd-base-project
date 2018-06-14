package com.stylefeng.guns.core.wrapper;

public class DictWrapperEntity {

	private String parentName;
	private String fieldName;
	private String replaceFieldName;

	public DictWrapperEntity() {
		super();
	}

	public DictWrapperEntity(String parentName, String fieldName, String replaceFieldName) {
		super();
		this.parentName = parentName;
		this.fieldName = fieldName;
		this.replaceFieldName = replaceFieldName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getReplaceFieldName() {
		return replaceFieldName;
	}

	public void setReplaceFieldName(String replaceFieldName) {
		this.replaceFieldName = replaceFieldName;
	}

	@Override
	public String toString() {
		return "DictWrapperEntity [parentName=" + parentName + ", fieldName=" + fieldName + ", replaceFieldName="
				+ replaceFieldName + "]";
	}

}
