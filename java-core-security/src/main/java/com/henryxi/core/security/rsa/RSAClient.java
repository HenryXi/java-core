package com.henryxi.core.security.rsa;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAClient {
    public static void main(String[] args) throws Exception {
        KeyPair kp = initKeyPair();
        System.out.println("--------public key--------");
        String publicKey = Base64.getMimeEncoder().encodeToString(kp.getPublic().getEncoded());
        System.out.println(publicKey);
        System.out.println("--------private key--------");
        String privateKey = Base64.getMimeEncoder().encodeToString(kp.getPrivate().getEncoded());
        System.out.println(privateKey);
        System.out.println("--------begin encrypt and decrypt--------");
        String tobeEncrypted = "this is sample string";
        System.out.println("--------test string--------");
        System.out.println(tobeEncrypted);
        String afterEncrypted = encryptByPublicKey(tobeEncrypted, publicKey);
        System.out.println("--------after encrypted--------");
        System.out.println(afterEncrypted);
        String afterDecrypted = decryptByPrivateKey(afterEncrypted, privateKey);
        System.out.println("--------after decrypted--------");
        System.out.println(afterDecrypted);
    }

    private static KeyPair initKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        return kpg.generateKeyPair();
    }

    private static String encryptByPublicKey(String plainText, String publicKey) throws Exception {
        PublicKey e = getPublicKey(publicKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, e);
        byte[] enBytes = cipher.doFinal(plainText.getBytes("utf-8"));
        return Base64.getMimeEncoder().encodeToString(enBytes);
    }

    private static String decryptByPrivateKey(String enStr, String privateKey) throws Exception {
        PrivateKey e = getPrivateKey(privateKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, e);
        byte[] deBytes = cipher.doFinal(Base64.getMimeDecoder().decode(enStr));
        return new String(deBytes);
    }

    private static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.getMimeDecoder().decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.getMimeDecoder().decode(key.getBytes("utf-8"));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
}
