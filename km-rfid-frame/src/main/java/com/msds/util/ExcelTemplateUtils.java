package com.msds.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Excel工具类基于模板方式
 * 
 * @ClassName ExcelTemplateUtils
 * @Description TODO
 * @author LiLong
 * @date 2015年3月23日 下午5:22:15
 * 
 */
public class ExcelTemplateUtils {

	/**
	 * 输出EXCEL2003,模板的集合参数为listdata
	 * 
	 * @Description TODO
	 * @param templatePath
	 *            模板路径
	 * @param listdata
	 *            数据集合
	 * @param out
	 *            输出流
	 * @throws Exception
	 * @return void
	 */
	public static void doExcel(String templatePath, List listdata,
			OutputStream out) throws Exception {
		Map map = new HashMap();
		map.put("listdata", listdata);
		doExcel(templatePath, map, out);
	}

	/**
	 * 输出EXCEL2003,模板的集合参数为Map的Key
	 * 
	 * @Description TODO
	 * @param templatePath
	 *            模板路径
	 * @param map
	 *            Map数据集合
	 * @param out
	 *            输出流
	 * @throws Exception
	 * @return void
	 */
	public static void doExcel(String templatePath, Map map, OutputStream out)
			throws Exception {
		// Date date = new Date();
		// DateFormat dfm = new SimpleDateFormat("yyyyMMddHHmmss");
		InputStream in = null;
		Workbook workbook;
		try {
			in = new FileInputStream(templatePath);
			// map.put("time", "打印时间：" + dfm.format(date));
			XLSTransformer transformer = new XLSTransformer();
			workbook = transformer.transformXLS(in, map);
			workbook.write(out);
			out.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
	}
}
