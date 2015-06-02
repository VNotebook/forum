package foro

import java.security.MessageDigest

class SecurityUtils {
    static String md5(String text) {
        if (text == null) {
            return null
        }

        return MessageDigest.getInstance("MD5").digest(text.bytes).encodeHex().toString()
    }
}
