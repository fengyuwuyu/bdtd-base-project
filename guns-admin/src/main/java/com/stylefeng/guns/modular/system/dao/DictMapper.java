package com.stylefeng.guns.modular.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.Dict;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author lilei123
 * @since 2018-06-19
 */
public interface DictMapper extends BaseMapper<Dict> {

	List<Map<String, Object>> selectDictMapList();

	List<Map<String, Object>> selectListObtainParentName(@Param("pid") Integer pid, @Param("name") String name);
}
