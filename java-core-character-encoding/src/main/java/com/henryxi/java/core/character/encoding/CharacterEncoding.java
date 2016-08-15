package com.henryxi.java.core.character.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CharacterEncoding {
    public static void main(String[] args) {
        String originalStr = "ä¸\u00ADæ\u0096\u0087æµ\u008Bè¯\u0095";
        for (String target : Charset.availableCharsets().keySet()) {
            for (String original : Charset.availableCharsets().keySet()) {
                try {
                    String afterDecode = new String(originalStr.getBytes(original), target);
                    if (afterDecode.contains("?")||afterDecode.contains("!")||afterDecode.contains("？")) {
                        continue;
                    }
                    System.out.println("original:" + original + ",target:" + target +
                            ",String:" + afterDecode);
                } catch (UnsupportedEncodingException e) {
                    continue;
                } catch (UnsupportedOperationException e) {
                    continue;
                }
            }
        }

    }

}
