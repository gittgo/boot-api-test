package com.example.bootapitest.hntest.dto;


import com.sun.crypto.provider.SunJCE;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

/**
 * 加密解密类
 */

public class CryptValiUtil {

    public static Map<String, String> versionMap = new HashMap<String, String>();

    static {
        versionMap.put("5", "fmsservice");
    }

    public static String decryptAES(String password, String key) {
        if (null == key || "".equals(key) || key.length() != 16) {
            return null;
        }
        byte[] raw;
        try {
            raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "des");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = hex2byte(password);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptAES(String password) {
        return decryptAES(password, "fmsservice");
    }

    public String encryptAES(String password, String key) {
        return executeAES(password, "fmsservice");

    }

    public static String encryptAES(String password) {
        return executeAES(password, "fmsservice");
    }

    /**
     * 加密逻辑
     *
     * @param password 密码
     * @param key      钥匙
     * @return String
     */
    private static String executeAES(String password, String key) {
        if (null == key || "".equals(key)) {
            return null;
        }
        byte[] raw;
        try {
            raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(password.trim().getBytes());
            return byte2hex(encrypted).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String byte2hex(byte[] readdat) {
        String res = "";
        for (int i = 0; i < readdat.length; i++) {
            String t = Integer.toHexString(readdat[i]);
            if (t.length() == 1) {
                res += "0" + t;
            } else if (t.length() > 2) {
                res += t.substring(t.length() - 2, t.length());
            } else {
                res += t;
            }
        }
        return res;
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }


    private static final String Algorithm = "DESede"; // 定义加密算法,可用DES,DESede,Blowfish

    // keybyte为加密密钥，长度为24字节
    // src为被加密的数据缓冲区（源）
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);// 在单一方面的加密或解密
        } catch (NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // keybyte为加密密钥，长度为24字节
    // src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // 转换成十六进制字符串
    public static String byte2Hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static byte[] hex(String username) {
        String f = getMD5(username);
        byte[] bkeys = new String(f).getBytes();
        byte[] enk = new byte[24];
        for (int i = 0; i < 24; i++) {
            enk[i] = bkeys[i];
        }
        return enk;
    }

    public static String getMD5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));
            byte[] encryption = md5.digest();

            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String encrypt3DES(String password) throws UnsupportedEncodingException {
        password = URLEncoder.encode(password, "utf-8");
        byte[] enk = hex("busgpstcps");//
//		Security.addProvider(new SunJCE());
        byte[] encoded = encryptMode(enk, password.getBytes());
        String pword = Base64.encode(encoded);
        return pword;
    }

    public static String decrypt3DES(String password) {
        String response = "";
        byte[] enk = hex("busgpstcps");//
        Security.addProvider(new SunJCE());
        if (password != null) {
            byte[] reqPassword = Base64.decode(password);
            if (reqPassword != null) {
                byte[] srcBytes = decryptMode(enk, reqPassword);
                if (srcBytes != null) {
                    try {
                        response = URLDecoder.decode(new String(srcBytes), "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return response;
    }
}
