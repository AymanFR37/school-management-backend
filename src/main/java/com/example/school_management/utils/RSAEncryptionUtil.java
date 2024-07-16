package com.example.school_management.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.KeyPair;

@RequiredArgsConstructor
@Component
public class RSAEncryptionUtil {
    private final KeyPair keyPair;

    public String decrypt(byte[] encryptedBytes) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(String plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            return cipher.doFinal(plaintext.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
