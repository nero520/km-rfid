package com.msds.baseinfo.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.baseinfo.entity.InitForm;
import com.msds.baseinfo.entity.ProductDetail;
import com.msds.baseinfo.service.InitService;

@Controller
public class InitController extends CommonActionSupport {

	@Resource(name = "initServiceImpl")
	private InitService initService;

	@RequestMapping(value = "/initData/search")
	public String searchAuthGroup() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		return "/init_date/init_list";
	}

	/**
	 * 分类树
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/initData/getCategoryList")
	public @ResponseBody
	List<InitForm> getCategoryList(InitForm init) throws IOException {

		if (null == init.getId()) {
			init.setId(-1);
		}

		List<InitForm> authObjectList = initService.getCategoryList(init);

		List<InitForm> productCategory = initService
				.getProductCategoryList(init);

		for (InitForm ob : authObjectList) {
			Boolean isCheck = false;
			if (null != ob.getLevel() && ob.getLevel() != 7) {
				ob.setIsLeaf(false);
				ob.setExpanded(false);
			}

			for (InitForm pc : productCategory) {

				String pids[] = pc.getCategoryId().split(",");

				for (int i = 0; i < pids.length; i++) {
					if (null != pids[i] && !"".equals(pids[i])) {
						if (String.valueOf(pids[i]).equals(
								String.valueOf(ob.getId()))) {
							isCheck = true;
						}
					}
				}
			}

			ob.setChecked(isCheck);
		}

		return authObjectList;
	}

	/**
	 * 产品列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/initData/getProductList")
	public @ResponseBody
	List<ProductDetail> getProductList(ProductDetail product)
			throws IOException {

		if (null == product.getProductCode()
				|| "".equals(product.getProductCode())) {
			product.setProductCode(null);
		}
		if (null == product.getStatus() || "".equals(product.getStatus())) {
			product.setStatus(null);
		}
		List<ProductDetail> list = initService.getProductList(product);

		return list;
	}

	/**
	 * 相关产品列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/initData/getProductDetailList")
	public @ResponseBody
	List<ProductDetail> getProductDetailList(ProductDetail product)
			throws IOException {

		List<ProductDetail> list = initService.getProductDetailList(product);

		return list;
	}

	/**
	 * 已选产品列表
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/initData/getProductJoinList")
	public @ResponseBody
	List<InitForm> getProductJoinList(InitForm product) throws IOException {

		List<InitForm> list = initService.getProductJoinList(product);

		return list;
	}

	/**
	 * 保存配件、车型对应关系
	 */
	@RequestMapping(value = "/initData/saveProductCategory", method = RequestMethod.POST)
	public @ResponseBody
	Map saveProductCategory(String productIds, String ids) throws IOException {

		try {

			// 产品ID集合
			String pids[] = productIds.split(",");

			if (null != pids && pids.length > 0) {
				for (int i = 0; i < pids.length; i++) {
					String pid = pids[i];
					initService.deleteCategoryByProductId(new Integer(pid));

					// 每个产品对应的分类集合
					String cids[] = ids.split(",");

					if (null != cids && cids.length > 0) {

						// 根据最后一个节点的ID查询 级联ID
						Map<String, String> map = new HashMap<String, String>();
						for (int j = 0; j < cids.length; j++) {
							InitForm form = new InitForm();
							form.setCategoryId(cids[j]);
							List<InitForm> list = initService
									.getCategoryIds(form);
							for (InitForm init : list) {
								map.put(init.getIds(), pid);
							}
						}

						//
						Set<Map.Entry<String, String>> set = map.entrySet();
						for (Iterator<Map.Entry<String, String>> it = set
								.iterator(); it.hasNext();) {
							Map.Entry<String, String> entry = (Map.Entry<String, String>) it
									.next();

							InitForm init = new InitForm();
							init.setIds(entry.getKey());
							init.setProductId(new Integer(entry.getValue()));
							initService.saveProductCategory(init);
							ProductDetail pd = new ProductDetail();
							pd.setId(new Integer(entry.getValue()));
							pd.setStatus("1");
							initService.updateStatus(pd);
						}

					} else {
						ProductDetail pd = new ProductDetail();
						pd.setId(new Integer(pid));
						pd.setStatus("0");
						initService.updateStatus(pd);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return returnMessage(2, "操作失败！");
		}
		return returnMessage(0, "操作成功");
	}

}
