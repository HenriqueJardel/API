package com.trabalho.api.services.validation.util;

public class Rga {
    
    public static boolean rgaIsValid(String rga) {
        if (rga.length() == 15 && rga.substring(4,5).equals(".") && rga.substring(9,10).equals(".") && rga.substring(13,14).equals("-"))
            return true;
        else 
            return false;
    }
}
