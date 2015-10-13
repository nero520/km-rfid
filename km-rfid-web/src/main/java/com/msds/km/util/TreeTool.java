package com.msds.km.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeTool {
	private List<TreeEntity> allList;// 所有分组信息
	private List<TreeEntity> selectedList;// 所有分组信息
	private String title;

	/**
	 * 用于构造简单的树
	 * 
	 * @param allList
	 *            所有节点的TreeEntity
	 * @param title
	 *            树的显示名字 声明完成后调用getTree方法
	 */
	public TreeTool(List<TreeEntity> allList, String title) {
		this.allList = allList;
		this.title = title;
	}

	@SuppressWarnings("unchecked")
	public Map getTree() {
		Map map = new HashMap<String, Object>();
		map.put("id", 0);
		map.put("text", title);
		getMeleafTree(map, 0);
		return map;
	}

	/**
	 * 用于构造选中节点的树
	 * 
	 * @param allList
	 *            所有节点的TreeEntity
	 * @param selectedList
	 *            选中节点的TreeEntity集合
	 * @param title
	 *            树的显示名字 声明完成后调用getSelectedTree
	 */
	public TreeTool(List<TreeEntity> allList, List<TreeEntity> selectedList,
			String title) {
		this.allList = allList;
		this.selectedList = selectedList;
		this.title = title;
	}

	@SuppressWarnings("unchecked")
	public Map getSelectedTree() {
		Map map = new HashMap<String, Object>();
		map.put("id", 0);
		map.put("text", title);
		getSelectedTree(map, 0);
		return map;
	}

	@SuppressWarnings({ "unchecked", "unused", "null", "rawtypes" })
	private void getMeleafTree(Map p, Integer parentId) {
		Map listMap;
		List<Map> childList = null;
		for (int i = 0; i < allList.size(); i++) {
			TreeEntity treeEntity = allList.get(i);
			if (treeEntity.getParentId() == parentId) {
				if (childList == null) {
					childList = new ArrayList<Map>();
				}
				Map childMap = new HashMap<String, Object>();
				childMap.put("id", treeEntity.getId());
				childMap.put("text", treeEntity.getText());
				childList.add(childMap);
				getMeleafTree(childMap, treeEntity.getId());
			}
		}
		if (childList != null) {
			p.put("children", childList);
		}
	}

	@SuppressWarnings({ "unchecked", "unused", "null", "rawtypes" })
	private void getSelectedTree(Map p, Integer parentId) {
		Map listMap;
		List<Map> childList = null;
		for (int i = 0; i < allList.size(); i++) {
			TreeEntity treeEntity = allList.get(i);
			if (treeEntity.getParentId() == parentId) {
				if (childList == null) {
					childList = new ArrayList<Map>();
				}
				Map childMap = new HashMap<String, Object>();
				childMap.put("id", treeEntity.getId());
				childMap.put("text", treeEntity.getText());
				for (int k = 0; k < selectedList.size(); k++) {
					if (selectedList.get(k).getId() == treeEntity.getId()) {
						childMap.put("checked", true);
						break;
					}
				}
				childList.add(childMap);
				getSelectedTree(childMap, treeEntity.getId());
			}
		}
		if (childList != null) {
			p.put("children", childList);
		}
	}
}
