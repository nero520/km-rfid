package com.msds.util;


import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;


 
 
public class DesUtil {
	private final static Logger logger = Logger.getLogger(DesUtil.class);
	
    private final static String DES = "DES";
    private static String SECURITY_PRIVATE_KEY = "MsDskmo2o-8A73237D-93CD-99D9-99E7-75956E5DFA4E-SecurityKey";
    
    
    public static void main(String[] args) throws Exception {
        String data = "12dd3456";
        System.out.println("加密:"+encrypt(data));
        System.out.println("解密:"+decrypt(encrypt(data)));
        
 
    }
    
    /**
     * 加密
     * @param data 解密字符串
     * @return
     */
    public static String encrypt(String data) {
    	String str = "";
    	try {
    		str =  encrypt(data,SECURITY_PRIVATE_KEY);
		} catch (Exception e) {
			logger.error("DES加密异常", e);
		}
    	
        return str;
    }
    
    /**
     * 解密
     * @param data 加密字符串
     * @return
     */
    public static String decrypt(String data) {
    	String str = "";
    	try {
    		str =  decrypt(data,SECURITY_PRIVATE_KEY);
    	} catch (Exception e) {
    		logger.error("DES解密异常", e);
    	}
    	
    	return str;
    }
     
    /**
     * Description 根据键值进行加密
     * @param data 
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        Base64 encoder = new Base64();
       // String strs = new BASE64Encoder().encode(bt);
        String strs = encoder.encodeToString(bt);
        return strs;
    }
 
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
      //  BASE64Decoder decoder = new BASE64Decoder();
        Base64 decoder = new Base64();
       // byte[] buf = decoder.decodeBuffer(data);
        byte[] buf = decoder.decode(data);
        byte[] bt = decrypt(buf,key.getBytes());
        return new String(bt);
    }
 
    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
 
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
 
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
 
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
}