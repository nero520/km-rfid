package com.msds.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Util;

/**
 * 防原理：
 * 1. 正则表达式的白名单过滤机制。
 * 2. 正则表达式的黑名单替换机制。
 * 3. 通过DOM对象过滤白名单和黑名单的标签
 */
public final class XSSReplaceUtils {
	
	/**
	 * 不可实例化
	 */
	private XSSReplaceUtils(){	
	}
	
	static final Pattern SCRIPT_TAG_PATTERN = Pattern.compile(
			"<script[^>]*>.*</script[^>]*>", Pattern.CASE_INSENSITIVE);//启用不区分大小写的匹配

	static final PatternCompiler pc = new Perl5Compiler();

	static final PatternMatcher matcher = new Perl5Matcher();

	/**
	 * 
	 *正则表达式的黑名单替换机制
	 */
	public static String antiXSS(String content) {
		
		String old = content;
		String ret = _antiXSS(content);
		while (!ret.equals(old)) {
			old = ret;
			ret = _antiXSS(ret);
		}
		return ret;
	}
    
	/**
	 * 替换顺序script标签,事件触发器,Hex,css,协议
	 */
	private static String _antiXSS(String content) {
		
		try {
			return stripAllowScriptAccess(stripProtocol(stripCssExpression(stripAsciiAndHex(stripEvent(stripScriptTag(content))))));
		} catch (Exception e) {
			
			return content;
		}
	}
    
	/**
	 * 
	 *防script标签
	 * 
	 */
	private static String stripScriptTag(String content) {
		Matcher m = SCRIPT_TAG_PATTERN.matcher(content);
		content = m.replaceAll("");
		return content;
	}
    /**
     * 
     * 防事件触发器攻击 
     * 
     */
	private static String stripEvent(String content) throws Exception {
		
		String[] events = { "onmouseover", "onmouseout", "onmousedown",
				"onmouseup", "onmousemove", "onclick", "ondblclick",
				"onkeypress", "onkeydown", "onkeyup", "ondragstart",
				"onerrorupdate", "onhelp", "onreadystatechange", "onrowenter",
				"onrowexit", "onselectstart", "onload", "onunload",
				"onbeforeunload", "onblur", "onerror", "onfocus", "onresize",
				"onscroll", "oncontextmenu" };
		for (String event : events) {
			org.apache.oro.text.regex.Pattern p = pc.compile("(<[^>]*)("
					+ event + ")([^>]*>)", Perl5Compiler.CASE_INSENSITIVE_MASK);//匹配操作不区分大小写
			if (null != p)
				content = Util.substitute(matcher, p, new Perl5Substitution(
						"$1" + event.substring(2) + "$3"), content,
						Util.SUBSTITUTE_ALL);

		}
		return content;
	}

	/**
	 * 
	 * 防AsciiAndHex攻击(&# \00xx)
	 * 
	 */
	private static String stripAsciiAndHex(String content) throws Exception {
		
		org.apache.oro.text.regex.Pattern p = pc.compile(
				"(<[^>]*)(&#|\\\\00)([^>]*>)",
				Perl5Compiler.CASE_INSENSITIVE_MASK);
		if (null != p)
			content = Util
					.substitute(matcher, p, new Perl5Substitution("$1$3"),
							content, Util.SUBSTITUTE_ALL);
		return content;
	}
    
	/**
	 * 
	 * 防css攻击
	 * 
	 */
	private static String stripCssExpression(String content) throws Exception {
		org.apache.oro.text.regex.Pattern p = pc.compile(
				"(<[^>]*style=.*)/\\*.*\\*/([^>]*>)",
				Perl5Compiler.CASE_INSENSITIVE_MASK);
		if (null != p)
			content = Util
					.substitute(matcher, p, new Perl5Substitution("$1$2"),
							content, Util.SUBSTITUTE_ALL);

		p = pc
				.compile(
						"(<[^>]*style=[^>]+)(expression|javascript|vbscript|-moz-binding)([^>]*>)",
						Perl5Compiler.CASE_INSENSITIVE_MASK);
		if (null != p)
			content = Util
					.substitute(matcher, p, new Perl5Substitution("$1$3"),
							content, Util.SUBSTITUTE_ALL);

		p = pc.compile("(<style[^>]*>.*)/\\*.*\\*/(.*</style[^>]*>)",
				Perl5Compiler.CASE_INSENSITIVE_MASK);
		if (null != p)
			content = Util
					.substitute(matcher, p, new Perl5Substitution("$1$2"),
							content, Util.SUBSTITUTE_ALL);

		p = pc
				.compile(
						"(<style[^>]*>[^>]+)(expression|javascript|vbscript|-moz-binding)(.*</style[^>]*>)",
						Perl5Compiler.CASE_INSENSITIVE_MASK);
		if (null != p)
			content = Util
					.substitute(matcher, p, new Perl5Substitution("$1$3"),
							content, Util.SUBSTITUTE_ALL);
		return content;
	}

	/**
	 * 
	 * 协议处理
	 * 
	 */
	private static String stripProtocol(String content) throws Exception {
		String[] protocols = { "javascript", "vbscript", "livescript",
				"ms-its", "mhtml", "data", "firefoxurl", "mocha" };
		for (String protocol : protocols) {
			org.apache.oro.text.regex.Pattern p = pc.compile("(<[^>]*)"
					+ protocol + ":([^>]*>)",
					Perl5Compiler.CASE_INSENSITIVE_MASK);
			if (null != p)
				content = Util.substitute(matcher, p, new Perl5Substitution(
						"$1/$2"), content, Util.SUBSTITUTE_ALL);
		}
		return content;
	}

	/**
	 * 
	 * 防用allowScriptAccess在Flash中引用用getURL,
	 *
	 */
	private static String stripAllowScriptAccess(String content)
			throws Exception {
		org.apache.oro.text.regex.Pattern p = pc.compile(
				"(<[^>]*)AllowScriptAccess([^>]*>)",
				Perl5Compiler.CASE_INSENSITIVE_MASK);
		if (null != p)
			content = Util.substitute(matcher, p, new Perl5Substitution(
					"$1Allow_Script_Access$2"), content, Util.SUBSTITUTE_ALL);
		return content;
	}

}
