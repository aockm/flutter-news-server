package com.tockm.utils;

import java.security.MessageDigest;

public class SHA256WithSalt {
    public static String sha256WithSalt(String input) {
        try {
            String salt = "";
            // 合并输入和盐值
            String saltedInput = input + salt;

            // 获取 SHA-256 实例
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(saltedInput.getBytes("UTF-8"));

            // 转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("加密失败", e);
        }
    }
}
