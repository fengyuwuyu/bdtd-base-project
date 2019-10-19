package com.stylefeng.guns.system;

import javax.annotation.Resource;

import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.modular.system.dao.DictMapper;
import com.stylefeng.guns.modular.system.service.IDictService;

/**
 * 字典服务测试
 *
 * @author 
 * @date 2017-04-27 17:05
 */
public class DictTest extends BaseJunit {

    @Resource
    IDictService dictService;

    @Resource
    DictMapper dictMapper;
}
