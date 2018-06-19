package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.MedicalInventorySecondLevel;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 药品二级库存管理 Mapper 接口
 * </p>
 *
 * @author lilei123
 * @since 2018-06-18
 */
public interface MedicalInventorySecondLevelMapper extends BaseMapper<MedicalInventorySecondLevel> {

	void storage(@Param("id") Integer id, @Param("count") Long count);

}
