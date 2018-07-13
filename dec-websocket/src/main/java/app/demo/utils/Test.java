package app.demo.utils;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.security.NoSuchAlgorithmException;

public class Test {
    public static void main(String[] args) {
        String s = "123123123";
        try {
            String s1 = HMacMD5.encodeMac(s, s);
            System.out.println(s1.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
