package com.business.delivery.util;

import java.util.HashMap;
import java.util.regex.Matcher;

public class Patterns {

    public static final String NAME = "^[A-ZñÑÁÉÍÓÚ]?[a-zñáéíóú]{2,}(?: [A-ZñÑÁÉÍÓÚ]?[a-zñáéíóú]*)*$";
    public static final String EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String CELL = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
    public static final String DNI = "^[0-9]{8,8}$";
    public static final String ADDRESS = "^[A-Za-z0-9'\\.\\-\\s\\,\\(\\)]+$";

    public static final String PASS = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static HashMap<String, String> expres = new HashMap<String, String>() {
        {
            put("email", EMAIL);
            put("name", NAME);
            put("cell", CELL);
            put("dni", DNI);
            put("address", ADDRESS);
            put("password", PASS);
        }
    };

    public static boolean chkVldFnc(String tipo, String valor) {
        String namRegExpVar = expres.get(tipo);//(([A-Z][a-z]+\.?\s?)+([A-Z]\.?\s?)*)
        java.util.regex.Pattern pVar = java.util.regex.Pattern.compile(namRegExpVar);
        Matcher mVar = pVar.matcher(valor);
        System.out.println(tipo +" "+mVar.matches() );
        return mVar.matches();
    }

}
