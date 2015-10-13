/**
 * 
 */
package com.msds.km.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;

/**
 * Excel导出处理类
 * 
 * @author zhengxd
 * @version 2011-7-20
 */
public class ExcelUtil {

	public static void expToExcel(List<?> objList, BaseObject obj,
			String classZ, OutputStream outs) {

		List<String[]> valueList = new ArrayList<String[]>();

		String[] headers = obj.getHeaders();
		String[] dataIndexs = obj.getDataIndexs();

		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;
		try {
			classType = Class.forName(classZ);
			for (int i = 0; i < objList.size(); i++) {
				Object o = objList.get(i);

				String[] values = new String[headers.length];

				for (int j = 0; j < dataIndexs.length; j++) {
					String stringLetter = dataIndexs[j].substring(0, 1)
							.toUpperCase();
					String getName = "get" + stringLetter
							+ dataIndexs[j].substring(1);
					Method getMethod;
					try {
						getMethod = classType.getMethod(getName);
						Object value;
						try {
							value = getMethod.invoke(o);
							if (getMethod.getReturnType() == Date.class) {
								if (null != value && !"".equals(value))
									values[j] = DateUtils.DateToString(
											(Date) value, DateStyle.YYYY_MM_DD);
								else
									values[j] = "";
							} else {
								values[j] = null != value ? value.toString()
										: "-";
							}
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}

				valueList.add(values);
			}

			fillExcel(wb, headers, valueList, outs);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 分多个sheet导出
	public static void expToExcelFormat(List<?> objList, BaseObject obj,
			String classZ, OutputStream outs, int count) {

		List<String[]> valueList = new ArrayList<String[]>();

		String[] headers = obj.getHeaders();
		String[] dataIndexs = obj.getDataIndexs();

		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;
		try {
			classType = Class.forName(classZ);
			for (int i = 0; i < objList.size(); i++) {
				Object o = objList.get(i);

				String[] values = new String[headers.length];

				for (int j = 0; j < dataIndexs.length; j++) {
					String stringLetter = dataIndexs[j].substring(0, 1)
							.toUpperCase();
					String getName = "get" + stringLetter
							+ dataIndexs[j].substring(1);
					Method getMethod;
					try {
						getMethod = classType.getMethod(getName);
						Object value;
						try {
							value = getMethod.invoke(o);
							if (getMethod.getReturnType() == Date.class) {
								if (null != value && !"".equals(value))
									values[j] = DateUtils.DateToString(
											(Date) value, DateStyle.YYYY_MM_DD);
								else
									values[j] = "";
							} else {
								values[j] = null != value ? value.toString()
										: "-";
							}
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}

				valueList.add(values);
			}

			// added by zhengxd 2012-08-04 大数据量导出时，拆分成多个sheet
			// int count = 50000;//每个sheet的条数
			int sheetCount = valueList.size() / count + 1;

			for (int i = 0; i < sheetCount; i++) {

				int start = i * count;
				int end = (i + 1) * count;
				List<String[]> spList = new ArrayList<String[]>();
				if (end > valueList.size()) {
					spList = valueList.subList(start, valueList.size());
				} else {
					spList = valueList.subList(start, end);
				}
				fillExcelFormat(wb, headers, spList, outs);

			}

			try {
				wb.write(outs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 分多个sheet导出
	@SuppressWarnings("rawtypes")
	public static void expToExcel(Map<Map, List> map, OutputStream outs) {

		// map中封装了一个basemap、一个list
		// basemap又封装了一个字符串和一个对象（"发货汇总@com.yougou.order.domain.OrderSaleKPI",
		// baseObject）
		// list就是将要导出的数据列表， basemap中包括sheet名称 映射用的class 以及baseObject对象
		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;

		try {
			Set<Map.Entry<Map, List>> set = map.entrySet();
			for (Iterator<Map.Entry<Map, List>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<Map, List> entry = (Map.Entry<Map, List>) it.next();

				List<String[]> valueList = new ArrayList<String[]>();

				Map<String, BaseObject> baseMap = entry.getKey();

				Set<Map.Entry<String, BaseObject>> baseSet = baseMap.entrySet();
				for (Iterator<Map.Entry<String, BaseObject>> its = baseSet
						.iterator(); its.hasNext();) {
					Map.Entry<String, BaseObject> entrys = (Map.Entry<String, BaseObject>) its
							.next();

					BaseObject obj = entrys.getValue();
					String[] headers = obj.getHeaders();
					String[] dataIndexs = obj.getDataIndexs();

					// 将sheet名称与对应的PO对象用“@”拆分
					String arr[] = entrys.getKey().toString().split("@");
					classType = Class.forName(arr[1]);

					for (int i = 0; i < entry.getValue().size(); i++) {
						Object o = entry.getValue().get(i);
						String[] values = new String[headers.length];
						for (int j = 0; j < dataIndexs.length; j++) {
							String stringLetter = dataIndexs[j].substring(0, 1)
									.toUpperCase();
							String getName = "get" + stringLetter
									+ dataIndexs[j].substring(1);
							Method getMethod;
							try {
								getMethod = classType.getMethod(getName);
								Object value;
								try {
									value = getMethod.invoke(o);
									if (getMethod.getReturnType() == Date.class) {
										if (null != value && !"".equals(value))
											values[j] = DateUtils.DateToString(
													(Date) value,
													DateStyle.YYYY_MM_DD);
										else
											values[j] = "";
									} else {
										values[j] = null != value ? value
												.toString() : "-";
									}
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							} catch (SecurityException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							}
						}
						valueList.add(values);
					}
					// 指定sheet名称
					fillExcelFormat(wb, arr[0], headers, valueList, outs);
				}
			}
			try {
				wb.write(outs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 分多个sheet导出
	@SuppressWarnings("rawtypes")
	public static void expToExcel(Map<Map, List> map, String filePath) {

		// map中封装了一个basemap、一个list
		// basemap又封装了一个字符串和一个对象（"发货汇总@com.yougou.order.domain.OrderSaleKPI",
		// baseObject）
		// list就是将要导出的数据列表， basemap中包括sheet名称 映射用的class 以及baseObject对象
		HSSFWorkbook wb = new HSSFWorkbook();

		Class<?> classType;

		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			Set<Map.Entry<Map, List>> set = map.entrySet();
			for (Iterator<Map.Entry<Map, List>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<Map, List> entry = (Map.Entry<Map, List>) it.next();

				List<String[]> valueList = new ArrayList<String[]>();

				Map<String, BaseObject> baseMap = entry.getKey();

				Set<Map.Entry<String, BaseObject>> baseSet = baseMap.entrySet();
				for (Iterator<Map.Entry<String, BaseObject>> its = baseSet
						.iterator(); its.hasNext();) {
					Map.Entry<String, BaseObject> entrys = (Map.Entry<String, BaseObject>) its
							.next();

					BaseObject obj = entrys.getValue();
					String[] headers = obj.getHeaders();
					String[] dataIndexs = obj.getDataIndexs();

					// 将sheet名称与对应的PO对象用“@”拆分
					String arr[] = entrys.getKey().toString().split("@");
					classType = Class.forName(arr[1]);

					for (int i = 0; i < entry.getValue().size(); i++) {
						Object o = entry.getValue().get(i);
						String[] values = new String[headers.length];
						for (int j = 0; j < dataIndexs.length; j++) {
							String stringLetter = dataIndexs[j].substring(0, 1)
									.toUpperCase();
							String getName = "get" + stringLetter
									+ dataIndexs[j].substring(1);
							Method getMethod;
							try {
								getMethod = classType.getMethod(getName);
								Object value;
								try {
									value = getMethod.invoke(o);
									if (getMethod.getReturnType() == Date.class) {
										if (null != value && !"".equals(value))
											values[j] = DateUtils.DateToString(
													(Date) value,
													DateStyle.YYYY_MM_DD);
										else
											values[j] = "";
									} else {
										values[j] = null != value ? value
												.toString() : "-";
									}
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							} catch (SecurityException e) {
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							}
						}
						valueList.add(values);
					}
					// 指定sheet名称
					fillExcelFormat(wb, arr[0], headers, valueList, fileOut);
				}
			}
			try {

				wb.write(fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void fillExcel(HSSFWorkbook wb, String[] headers,
			List<String[]> valueList, OutputStream outs) {
		try {
			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);

			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}

			// HSSFFont fontC = wb.createFont();
			// 高度
			// fontC.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			// HSSFCellStyle styleC = wb.createCellStyle();
			// styleC.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// styleC.setFont(fontC);
			// styleC.setFillForegroundColor(HSSFColor.WHITE.index);
			// styleC.setBorderLeft((short) 1);
			// styleC.setBorderRight((short) 1);
			// styleC.setBorderTop((short) 1);
			// styleC.setWrapText(true);
			for (int i = 0; i < valueList.size(); i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = (String[]) valueList.get(i);

				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					// cell.setCellStyle(styleC);
					cell.setCellValue(new HSSFRichTextString(values[j]));
				}
			}
			wb.write(outs);
			// FileOutputStream fileOs;
			// fileOs = new FileOutputStream(new File("E:\\USR_TEST.xls"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fillExcelFormat(HSSFWorkbook wb, String[] headers,
			List<String[]> valueList, OutputStream outs) {
		try {
			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);

			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));

			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}

			// 数字转换
			for (int i = 0; i < valueList.size(); i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = (String[]) valueList.get(i);
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellStyle(cellstyle);
							cell.setCellValue(Float.parseFloat(values[j]));

						} else if (mX.matches()) {
							cell.setCellStyle(cellstyleX);
							cell.setCellValue(Float.parseFloat(values[j]));

						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fillExcelFormat(HSSFWorkbook wb, String sheetName,
			String[] headers, List<String[]> valueList, OutputStream outs) {
		try {
			HSSFSheet dynamicDS = wb.createSheet(sheetName);
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);

			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));

			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}

			// 数字转换
			for (int i = 0; i < valueList.size(); i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = (String[]) valueList.get(i);
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellStyle(cellstyle);
							cell.setCellValue(Long.parseLong(values[j]));
						} else if (mX.matches()) {
							cell.setCellStyle(cellstyleX);
							cell.setCellValue(Float.parseFloat(values[j]));
						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Excel导出，从界面获取导出的数据
	 */
	public static void expToExcel(BaseObject obj, OutputStream outs) {
		String[] headers = obj.getHeaders();
		String[] rowsDatas = obj.getRowDatas();
		HSSFWorkbook wb = new HSSFWorkbook();

		try {

			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);
			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));
			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}
			// 数字转换
			for (int i = 0; i < rowsDatas.length; i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = rowsDatas[i].split("@");
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyle);
						} else if (mX.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyleX);
						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]
									.trim()));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

			wb.write(outs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void expToExcelSymbo(BaseObject obj, OutputStream outs,
			String symbo) {
		String[] headers = obj.getHeaders();
		String[] rowsDatas = obj.getRowDatas();
		HSSFWorkbook wb = new HSSFWorkbook();

		try {

			HSSFSheet dynamicDS = wb.createSheet();
			dynamicDS.setAutobreaks(true);
			// 表头单元格的字体样式
			HSSFFont font = wb.createFont();
			// 高度
			font.setFontHeightInPoints((short) 12);
			// 表头单元格的对齐方式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderLeft((short) 1);
			style.setBorderRight((short) 1);
			style.setBorderTop((short) 1);
			style.setWrapText(true);
			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));

			HSSFCellStyle cellstyleX = wb.createCellStyle();
			cellstyleX.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));
			// 创建第一行
			HSSFRow hssfRowHeader1 = dynamicDS.createRow(0);

			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = hssfRowHeader1.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(headers[i]));
			}
			// 数字转换
			for (int i = 0; i < rowsDatas.length; i++) {
				HSSFRow hssfRowHeader = dynamicDS.createRow(i + 1);
				String[] values = rowsDatas[i].split(symbo);
				for (int j = 0; j < values.length; j++) {
					HSSFCell cell = hssfRowHeader.createCell(j);
					if (j != 0) {
						String pattern = "^(-?\\d+)";
						String patternX = "^(-?\\d+)(\\.\\d+{0,3})?$";
						Pattern p = Pattern.compile(pattern);
						Pattern pX = Pattern.compile(patternX);
						Matcher m = p.matcher(values[j]);
						Matcher mX = pX.matcher(values[j]);
						if (m.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyle);
						} else if (mX.matches()) {
							cell.setCellValue(Float.parseFloat(values[j]));
							cell.setCellStyle(cellstyleX);
						} else {
							cell.setCellValue(new HSSFRichTextString(values[j]));
						}
					} else {
						cell.setCellValue(new HSSFRichTextString(values[j]));
					}
				}
			}

			wb.write(outs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
