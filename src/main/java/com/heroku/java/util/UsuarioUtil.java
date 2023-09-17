package com.heroku.java.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UsuarioUtil {
    public static String CriptografarSenha(String senha, String email) {
        try {
            // Combine a senha e o email para criar uma string única
            String senhaComEmail = senha + email;

            // Crie uma instância de MessageDigest usando o algoritmo SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Calcule o hash da string combinada (senha + email)
            byte[] hashBytes = messageDigest.digest(senhaComEmail.getBytes());

            // Converta o hash em uma representação de string em Base64
            String hashSenha = Base64.getEncoder().encodeToString(hashBytes);

            return hashSenha;
        } catch (NoSuchAlgorithmException e) {
            // Lida com exceções, se ocorrerem, como NoSuchAlgorithmException
            e.printStackTrace();
            return null; // Ou lança uma exceção apropriada, dependendo do seu caso
        }
    }
}