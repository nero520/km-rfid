package com.msds.km;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.km.entity.CodeGenerateEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.mapper.CodeGenerateMapper;
import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;

@Service
public class CodeGenerator {

	@Autowired
	CodeGenerateMapper codeGenerateMapper;

	Lock lock = new ReentrantLock();

	private int codeLength = 6;

	/**
	 * 生成编码方法 格式 前缀 +日期+长度串+后缀
	 * 
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @param codeType
	 *            编号类型 @see com.msds.enums.CodeTypeEnum
	 * @return
	 */
	public String getCode(String prefix, String suffix, Integer codeType) {
		if (prefix == null)
			prefix = "";
		if (suffix == null) {
			suffix = "";
		}
		if (codeType == null || codeType == 0) {
			codeType = CodeTypeEnum.order_code.getId();
		}
		Date currentDate = new Date();
		String dateStr = DateUtils.DateToString(currentDate, DateStyle.YYMMDD);

		StringBuilder finalCodeSb = new StringBuilder();
		try {
			lock.lock();
			CodeGenerateEntity et = codeGenerateMapper.getEntity(codeType,
					prefix, suffix, dateStr);
			if (et == null) {
				et = new CodeGenerateEntity();
				et.setCodeType(codeType);
				et.setPrefix(prefix);
				et.setSuffix(suffix);
				et.setDateStr(dateStr);
				et.setCode(calculateCodeByLength(null));
				et.setModifyDate(currentDate);
				codeGenerateMapper.add(et);
			} else {
				et.setCode(calculateCodeByLength(et.getCode()));
				codeGenerateMapper.update(et);
			}
			finalCodeSb.append(prefix);
			finalCodeSb.append(dateStr);
			finalCodeSb.append(et.getCode());
			finalCodeSb.append(suffix);
		} finally {
			lock.unlock();
		}

		return finalCodeSb.toString();
	}

	/**
	 * 生成编码方法 格式 前缀 +长度串+后缀
	 * 
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @param codeType
	 *            编号类型 @see com.msds.enums.CodeTypeEnum
	 * @param codeLength
	 *            长度
	 * @return
	 */
	public String getCodeWithoutDate(String prefix, String suffix,
			Integer codeType, Integer codeLength) {
		if (codeLength != null && codeLength > 0) {
			this.codeLength = codeLength;
		}
		if (prefix == null)
			prefix = "";
		if (suffix == null) {
			suffix = "";
		}
		if (codeType == null || codeType == 0) {
			codeType = CodeTypeEnum.order_code.getId();
		}
		Date currentDate = new Date();
		String dateStr = "";

		StringBuilder finalCodeSb = new StringBuilder();
		try {
			lock.lock();
			CodeGenerateEntity et = codeGenerateMapper.getEntity(codeType,
					prefix, suffix, dateStr);
			if (et == null) {
				et = new CodeGenerateEntity();
				et.setCodeType(codeType);
				et.setPrefix(prefix);
				et.setSuffix(suffix);
				et.setDateStr(dateStr);
				et.setCode(calculateCodeByLength(null));
				et.setModifyDate(currentDate);
				codeGenerateMapper.add(et);
			} else {
				et.setCode(calculateCodeByLength(et.getCode()));
				codeGenerateMapper.update(et);
			}
			finalCodeSb.append(prefix);
			finalCodeSb.append(dateStr);
			finalCodeSb.append(et.getCode());
			finalCodeSb.append(suffix);
		} finally {
			lock.unlock();
		}

		return finalCodeSb.toString();
	}

	private String calculateCodeByLength(String initCode) {
		StringBuilder codeSb = new StringBuilder();
		if (initCode == null || initCode.equals("")) {
			for (int i = 0; i < codeLength - 1; i++) {
				codeSb.append("0");
			}
			codeSb.append("1");
		} else {
			long intCode = Long.parseLong(initCode);
			intCode++;
			String strCode = String.valueOf(intCode);
			for (int i = 0; i < codeLength - (strCode.length()); i++) {
				codeSb.append("0");
			}
			codeSb.append(strCode);
		}

		return codeSb.toString();
	}
}
