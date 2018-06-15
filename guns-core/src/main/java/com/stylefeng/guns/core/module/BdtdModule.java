package com.stylefeng.guns.core.module;

public enum BdtdModule {
	
	SYSTEM(1001, "系统模块"),
	MEDICAL_INVENTORY(1002, "药房管理");

	private int moduleId;
	private String desc;

	private BdtdModule(int moduleId, String desc) {
		this.moduleId = moduleId;
		this.desc = desc;
	}

	public int getModuleId() {
		return moduleId;
	}

	public String getDesc() {
		return desc;
	}

}
