package com.ruoyi.web.controller.Utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



/**
 * RSA签名验签类
 */
public class RSASignature {

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    
	/**
	 * 针对参数进行排序拼装
	 * @paramsortedParams
	 * @return
	 */
	public static String getOrderContent(Map<String, Object> requestParam) {
		Map<String, Object> sortedParams = new TreeMap<String, Object>();
		if ((requestParam != null) && (requestParam.size() > 0)) {
			sortedParams.putAll(requestParam);
		}
		StringBuffer content = new StringBuffer();
		List<String> keys = new ArrayList<String>(sortedParams.keySet());
		Collections.sort(keys);
		int index = 0;
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			Object value = sortedParams.get(key);
			if (key!=null &&!"".equals(key)&& value != null) {
				content.append((index == 0 ? "" : "&") + key + "=" + value);
				index++;
			}
		}
		return content.toString();
	}


    /**
     * RSA签名
     *
     * @param content    待签名数据
     * @param privateKey 商户私钥
     * @param encode     字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(decryptBASE64(privateKey));

            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));

            byte[] signed = signature.sign();

            return new String(encryptBASE64(signed));
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }

    }

    /**
     * rsa 签名
     * @param content 待签名内容
     * @param privateKey  私钥
     * @return
     */
    public static byte[] sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(decryptBASE64(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes("UTF-8"));
            byte[] signed = signature.sign();
            return signed;
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
    
    static String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDkhXIY57TCsGLsod3Y76tKTi+HiYv7Od9ROSYphPUEgbbC5ghjGJCDTbwkkPFC2EQxgZjn+hDY1N73drQqoR6Y+yuwt/RlscWSP6CTbNeQTXqpw01TzPDez4GtREzEQSWdM16jqJVb3TJQuHBi9CCfZxReZB25LJ1t0DyNef1CpQIDAQAB";
	static String priKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOSFchjntMKwYuyh3djvq0pOL4eJi/s531E5JimE9QSBtsLmCGMYkINNvCSQ8ULYRDGBmOf6ENjU3vd2tCqhHpj7K7C39GWxxZI/oJNs15BNeqnDTVPM8N7Pga1ETMRBJZ0zXqOolVvdMlC4cGL0IJ9nFF5kHbksnW3QPI15/UKlAgMBAAECgYBP6pcfPJDLcTH3PRg/UHmfr74RcTnB7tg5KHo/FN8250IJ4LZYKXQIZzv/saydytH2WjMmFR6lJbSf6CRTsCrpfb3V1gFmOH7LYAcs/sY5hjuc1A7FAg/B3AIBkcU6/KsmNM1b+GjIXOj1vWuPPioARJMpTpsdprn6L98PlrZUFQJBAPzr/YZ8HPApcE7vLtHLOuZvjmE7AS0YGpspQvfCsoyuJ257Gev0ObJPCvt9hV0TSDHyRVC+7fH4YLSZ4HrR5ZsCQQDnTW6t/OOjNKKKLonyXvm0ajSp+dOjHGZ4alvNmNxTY31o5kE8hqzBGz+ASEX/OtdrPvZDGBBiBbciyuG+Mhy/AkEAnFNUiRoPXNWQCAnH+33Msv9ClpA8wt2CHGMddDvP1ioSTzQhKnjybGZ0mErV8lhnqA9hjm3kbkmhpB7z45X2fwJBAN9i2yfR+w+eP/Rwae3YaBUkFWSr0QfQ3+4f2jXAEdm/Vlk/N3X7I1EEvdlo86FB9Naw4il+TiQ9HNfPVSHZSAUCQH7cbjch2ClJcx1ubhkZOR/UIaGYpoxcRwB2mgTzojQb32uztcz2RyMn2tgS/qcjtijr0fiPYhUI4TQFDLTs21M=";
    
    public static void main(String[] args) throws Exception{
    	
    	String aaa = "aa";
//		String sha1 = SHA1Util.SHA1(aaa);
//    	
    	String aa = "431884393236554E05D8FF381566005236";
    	String sign = RSASignature.sign(aa, priKey, "UTF-8");
    	System.out.println("*******"+sign);
//    	
//    	
//    	
//    	byte[] encryptByPublicKey = RSAUtil.encryptByPrivateKey(sign.getBytes(), priKey);
//		
//		String encode = Base64.encode(encryptByPublicKey);
//		System.out.println(encode);
//    	String sign = "kYwMM0r/M+bIreSSfEOPaos1JW48jLT8B2O20NKxEQy7kn3jM2TX4O5CrtWJOdoN4PPsS4WDu8kq8h1q++SS5i5FISqcpNuZdnn+nbrPu1nV/h10Lmyp2mZG88HmmRaqp4aXBo/wOtmIGzbctgNaCfoFOMbIMZRpTubUefpL/FQ=";
//    	
    	boolean doCheck = RSASignature.doCheck(aa, sign, pubKey, "UTF-8");
    	System.out.println(doCheck);
    	
    	
	}

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey, String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = decryptBASE64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));

            boolean bverify = signature.verify(decryptBASE64(sign));
            return bverify;

        } catch (Exception e) {
        	e.printStackTrace();
             return false;
        }
    }

    /**
     * RSA验签名检查
     * @param content 待签名数据
     * @param sign 签名值
     * @param publicKey 分配给开发商公钥
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = decryptBASE64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes("UTF-8"));

            boolean bverify = signature.verify(decryptBASE64(sign));
            return bverify;

        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
    }

    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encode(key);
    }

    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

}
