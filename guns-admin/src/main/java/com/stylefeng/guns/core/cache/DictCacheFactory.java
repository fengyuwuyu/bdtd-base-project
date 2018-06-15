package com.stylefeng.guns.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stylefeng.guns.core.consts.DictConsts;
import com.stylefeng.guns.core.wrapper.DictWrapperEntity;
import com.stylefeng.guns.modular.system.dao.DictMapper;
import com.stylefeng.guns.modular.system.model.Dict;

@Component
public class DictCacheFactory {
	
	private static final String KEY = "key";
	private static final String PARENT_NAME_KEY = "parentName";

	private Map<String, Map<String, Object>> dictMap = new HashMap<>();
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private DictMapper dictMapper;
	
	public void init() {
		dictMap.clear();
		List<Map<String, Object>> dictList = dictMapper.selectDictMapList();
		dictList.forEach((item) -> {
			dictMap.put(item.get(KEY).toString(), item);
		});
	}
	
	public Map<String, Map<String, Object>> getDictMap() {
		return dictMap;
	}
	
	public void wrapper(List<Map<String, Object>> rows, List<DictWrapperEntity> dictwrapperEntities) {
		for (Map<String, Object> map : rows) {
			for (DictWrapperEntity entity : dictwrapperEntities) {
				Integer v = (Integer)map.get(entity.getFieldName());
				Object value = getDictMapByParentNameAndNum(entity.getParentName(), v).get(DictConsts.DICT_NAME);
				map.put(entity.getReplaceFieldName(), value);
			}
		}
	}
	
	/**
	 * 根据parentName和num获取dict对象
	 * @param parentName
	 * @param num
	 * @return
	 */
	public Map<String, Object> getDictMapByParentNameAndNum(String parentName, Integer num) {
		String key = parentName + "-" + num;
		return getDictMapByKey(key);
	}
	
	/**
	 * key为parentName和num拼的一个key，实例：parentName为"药品单位"，num为1，则key为"药品单位-1"
	 * @param key
	 * @return
	 */
	public Map<String, Object> getDictMapByKey(String key) {
		return dictMap.get(key);
	}
	

	
	public List<Dict> getDictListByParentName(String parentName) {
		return dictMap.entrySet().stream().filter((entry) -> {
			Map<String, Object> map = entry.getValue();
			if (map.get(PARENT_NAME_KEY).equals(parentName)) {
				return true;
			} 
			return false;
		}).map((entry) -> {
			return revertByMap(entry.getValue());
		}).collect(Collectors.toList());
	}
	
	private Dict revertByMap(Map<String, Object> dictMap) {
		Integer id = (Integer) dictMap.get("id");
		Integer num = (Integer) dictMap.get("num");
		Integer pid = (Integer) dictMap.get("pid");
		String name = (String) dictMap.get("name");
		String tips = (String) dictMap.get("tips");
		return new Dict(id, num, pid, name, tips);
	}
	
}
