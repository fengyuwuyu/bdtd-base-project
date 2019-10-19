package com.stylefeng.guns.modular.system.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.module.BdtdError;
import com.stylefeng.guns.core.util.DictCacheFactory;
import com.stylefeng.guns.modular.system.model.Dict;
import com.stylefeng.guns.modular.system.service.IDictService;

/**
 * 控制器
 *
 * @author 
 * @Date 2018-06-19 16:40:39
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    private String PREFIX = "/system/dict/";

    @Autowired
    private IDictService dictService;
    
    @Autowired
    private DictCacheFactory dictCacheFactory;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dict.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/dict_add/{pid}")
    public String dictAdd(@PathVariable Integer pid, Model model) {
    	model.addAttribute("pid", pid);
        return PREFIX + "dict_add.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/dict_sublist/{pid}")
    public String dictSubList(@PathVariable Integer pid, Model model) {
    	model.addAttribute("pid", pid);
        return PREFIX + "subDict.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/dict_update/{dictId}")
    public String dictUpdate(@PathVariable Integer dictId, Model model) {
        Dict dict = dictService.selectById(dictId);
        model.addAttribute("item",dict);
        LogObjectHolder.me().set(dict);
        return PREFIX + "dict_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list/{pid}")
    @ResponseBody
    public Object list(@PathVariable Integer pid, String condition, Integer offset, Integer limit) {
    	Wrapper<Dict> wrapper = new EntityWrapper<>();
    	wrapper.like("name", condition);
    	if (pid != null) {
    		wrapper.and().eq("pid", pid);
    	}
    	return dictService.selectListObtainParentName(pid, condition);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Dict dict) {
    	Date createDate = new Date();
		dict.setCreateDate(createDate);
		dict.setUpdateDate(createDate);
        dictService.insert(dict);
        
        dictCacheFactory.init();
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer dictId) {
    	Wrapper<Dict> wrapper = new EntityWrapper<>();
    	wrapper.eq("pid", dictId);
		int count = dictService.selectCount(wrapper );
		if (count > 0) {
			return new Tip(500, BdtdError.DELETE_DICT_CASCADE_ERROR.getMessage());
		}
        try {
            dictService.deleteById(dictId);
        } catch (Exception e) {
            log.error(e.getMessage());
            if (e instanceof MySQLIntegrityConstraintViolationException) {
                return new Tip(500, "该字典正在使用中，无法删除！");
            }
            return new Tip(500, "删除失败，服务器内部错误！");
        }
        
        dictCacheFactory.init();
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Dict dict) {
    	dict.setUpdateDate(new Date());
        dictService.updateById(dict);
        
        dictCacheFactory.init();
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{dictId}")
    @ResponseBody
    public Object detail(@PathVariable("dictId") Integer dictId) {
        return dictService.selectById(dictId);
    }
}
