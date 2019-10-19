package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Dict;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author lilei123
 * @since 2018-06-19
 */
public interface IDictService extends IService<Dict> {

	List<Map<String, Object>> selectListObtainParentName(Integer pid, String condition);

}
