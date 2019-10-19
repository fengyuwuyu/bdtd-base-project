package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Dict;
import com.stylefeng.guns.modular.system.dao.DictMapper;
import com.stylefeng.guns.modular.system.service.IDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author lilei123
 * @since 2018-06-19
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

	@Override
	public List<Map<String, Object>> selectListObtainParentName(Integer pid, String condition) {
		return this.baseMapper.selectListObtainParentName(pid, condition);
	}

}
