package com.example.school_management.converters;

import com.example.school_management.utils.RSAEncryptionUtil;
import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Encrypt implements AttributeConverter<String, byte[]> {

    private final RSAEncryptionUtil rsaEncryptionUtil;

    @Override
    public byte[] convertToDatabaseColumn(String attribute) {
        if (attribute == null)
            return null;
        return rsaEncryptionUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(byte[] dbData) {
        if (dbData == null)
            return null;
        return rsaEncryptionUtil.decrypt(dbData);
    }
}
