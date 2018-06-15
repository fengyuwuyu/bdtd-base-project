package com.stylefeng.guns.core.module;

public enum BdtdError {

	DELETE_CASCADE_ERROR(1, "该药品下还存在二级药品，请删除二级药品后再执行此操作", BdtdModule.MEDICAL_INVENTORY),
	DELETE_NOT_EXIST_ERROR(1, "该药品不存在", BdtdModule.MEDICAL_INVENTORY),
	
	;

	private int code;
	private String message;
	private BdtdModule module;

	private BdtdError(int code, String message, BdtdModule module) {
		this.code = code;
		this.message = message;
		this.module = module;
	}

	public long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public BdtdModule getModule() {
		return module;
	}
	
	public long getErrorCode() {
		if (this.module != null) {
			return formatErrorCode(this.module.getModuleId(), this.code);
		}
		return 0;
	}

	private long formatErrorCode(int module, int error) {
		return (((long) module) << 32) + (((long) error) & 0x00000000FFFFFFFFL);
	}
	
	public static void main(String[] args) {
		System.out.println(DELETE_CASCADE_ERROR.toString());
	}
}
