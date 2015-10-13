package com.msds.km.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 数据传输层层基类
 * 
 * @ClassName BaseVo
 * @Description TODO
 * @author LiLong
 * @date 2015年5月6日 上午10:48:58
 * 
 */
@JsonInclude(Include.NON_NULL)
public class BaseVo implements Serializable {

	private static final long serialVersionUID = 2417490427578791944L;

}
