# Java RSA encrypt decrypt example
In this page I will show you how to use `RSA` to encrypt and decrypt data. As we all know `RSA` is one of asymmetric 
cryptographic algorithm. We need generate public key and private key before encrypting and decrypting data. The sample
code is here.
```java
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
```
The output is here
```
--------public key--------
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZjyE2vCpYJS6CpVZTj8V34QnHkqPdHSkBeYBs
NP/HBIISf4tUdXf99r1YePmBmiAqPJF73zi8tgJpGitTkFQVMz8VdsRIjJnuxo3QfxsCY3wO/sxO
ufOZB3ndnICn2elfCzdT8Us110qPmT0OIiGqu8EOMFK6HCafj+hOYPW91QIDAQAB
--------private key--------
MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJmPITa8KlglLoKlVlOPxXfhCceS
o90dKQF5gGw0/8cEghJ/i1R1d/32vVh4+YGaICo8kXvfOLy2AmkaK1OQVBUzPxV2xEiMme7GjdB/
GwJjfA7+zE6585kHed2cgKfZ6V8LN1PxSzXXSo+ZPQ4iIaq7wQ4wUrocJp+P6E5g9b3VAgMBAAEC
gYAlln2A0mpjDSbnX+VTqvuhLnqgWWq28y5YaA9hbU+2vYnBUWsfj2mBxuXuRB5+9OUusYjDE47l
0n+gjoFQgSGzdTAGziojkWK/nt75EjJEAHOaAdF9v0+P4cy2lbQZIqiXg1xnVpolEhHWxnqhUcbu
weHzNVmPVX3xp9iuAXAZ+QJBANw1vW9+6dtv5lKgakrL5AJJaRD4D0YAa8AbBhTi211qxW/+haY/
jtsoh2o1teVjPYOghK2D3SpPl72tHl4BY+cCQQCyhEDaq0AwDtszo3txHrsDVqyb2CYI6fdJZ1NT
fH8sU0l3KGvxdwYPVP0ajEdpMvnkl0/ZevHE6dfCPF7tL5jjAkEAhdNS8LNcQ7NZcdVzQ0lto8Yh
R+K4xX3z/aduprrHPZppqoovhr0RgDa9NNq3VFRfSeL/PsPoYJJGUUsoLVEC+QJBALEEujbcGBNP
uAfVtgOvIG0oFpOXW+f88Y0lW5hu3MC8eh4hxCA2EZlEgpM/xVRJC0mkzbZv1qyX4a6nJM54I1cC
QGsQ+Wf2Zf0AL7eftH0276KjuYStDC4/snkWMizjN1qmTs2h/UIZm+465dRdiZzK0uW6pqOQkTmV
RV9+7BgOjGg=
--------begin encrypt and decrypt--------
--------test string--------
this is sample string
--------after encrypted--------
Uzb3nyKKB5B7T8zpIHOyL6tJm2cmgLk5z/+nZ4ouEdpqEtTi/7VNqU9NiIXZri3bl1cIgt0sHFIs
NsqXET9BMYRnMx4Zjm2yxkxlLQamS6czOaAOdHJU4pmy0lPjiSeVjyjGbR3iy/chSFQAwrXQv8Mm
gvM4Ny2AHolvbsJ+imM=
--------after decrypted--------
this is sample string
```

EOF