package com.enigma.walletkurs.additional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enigma.walletkurs.exception.HandlerException;

public class MD5 {
	String generatedPassword = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(HandlerException.class);
    
    public String getSecurePassword(String value) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(value.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("catchMD5Exception");
            LOGGER.error(e.getMessage());
            LOGGER.warn(e.getMessage());
            LOGGER.info(e.getMessage());
            LOGGER.debug(e.getMessage());
        }
        return generatedPassword;
    }

}
