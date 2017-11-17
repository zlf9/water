package com.zking.water.base.dao;

import java.util.List;

import com.zking.water.base.entity.Dict;

/**
 * 数据字典数据访问对象
 * 
 * @author Administrator
 *
 */
public interface IDictDAO extends IBaseDAO<Dict> {

	/**
	 * 根据字典名字得到字典对象集合
	 * 
	 * @param dictName
	 *            字典名字
	 * @return 字典对象集合
	 * @throws Exception
	 */
	public List<Dict> findAllByDictName(String dictName) throws Exception;

	/**
	 * 根据字典名字和字典值得到字典对象
	 * 
	 * @param dictName
	 *            字典名字
	 * @param value
	 *            字典值
	 * @return 字典对象
	 * @throws Exception
	 */
	public Dict findByDictNameAndValue(final Dict dict) throws Exception;
}
