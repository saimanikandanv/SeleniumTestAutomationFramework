package com.staf.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by Saimanikandan V on 23-04-2021
 */
public class EncryptionUtils {

    public static String getDecodedString(String encodedString)
    {
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }

}
