package com.msds.shiro.service;


import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>User: sutao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    
    public String getSalt(){
    	return randomNumberGenerator.nextBytes().toHex();
    }
   
//    public void encryptPassword(AuthUser user) {
//
//        user.setSalt(randomNumberGenerator.nextBytes().toHex());
//
//        String newPassword = new SimpleHash(
//                algorithmName,
//                user.getPassword(),
//                ByteSource.Util.bytes(user.getUserName()+user.getSalt()),
//                hashIterations).toHex();
//
//        user.setPassword(newPassword);
//    }
    
    /**
     * 获得
     * @param userName 用户名
     * @param salt 加密佐料
     * @param pas 明文密码
     * @return
     */
    public String getHexPassword(String userName,String salt,String pas){
    	return  new SimpleHash(
                algorithmName,
                pas,
                ByteSource.Util.bytes(userName+salt),
                hashIterations).toHex();
    }
    
    public static void main(String[] args) {
    	PasswordHelper passwordHelper = new PasswordHelper();
    	String userName = "lizhe";
    	String salt =passwordHelper. getSalt();
    	System.out.println(salt);
    	String paString = "123";
    	String hexPassword = passwordHelper.getHexPassword(userName,salt,paString);
    	System.out.println(hexPassword);
	}
}
