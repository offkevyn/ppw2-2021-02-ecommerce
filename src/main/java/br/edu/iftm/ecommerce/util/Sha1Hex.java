package br.edu.iftm.ecommerce.util;

import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Sha1Hex {

    public static String getHex(byte[] array) throws ErroSistemaException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.reset();
            md.update(array);
            byte[] digest = md.digest();

            String hexStr = "";
            for (int i = 0; i < digest.length; i++) {
                hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
            }
            return hexStr;
        } catch (NoSuchAlgorithmException ex) {
            throw new ErroSistemaException("Erro ao gerar chave SHA1", ex);
        }
    }

    public static String getHexWithRandomSalt(byte[] array) throws ErroSistemaException {
        String salt = UUID.randomUUID().toString();
        byte[] newArray = new byte[array.length + salt.getBytes().length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(salt.getBytes(), 0, newArray, array.length, salt.getBytes().length);
        return getHex(newArray);
    }
}