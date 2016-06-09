/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author usuario
 */
public class Conversoes {

    public static Date converterData(String data) {
        try {
            if (data != null || !data.trim().equals("")) {
                DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
                Date date = fmt.parse(data);
                return date;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao converter Data! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public static String converterDataBr(Date data) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateString = sdfr.format(data);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
}
