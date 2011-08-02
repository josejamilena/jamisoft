package es.lda.core.lib.util;

/**
 *
 * @author Jose Antonio
 */
public class LdaUtils {

    private LdaUtils() {
    }

    public static boolean toBoolean(String s) {
        if (s.length() < 3) { // 0,1,Sí,si,Si,sí,Yes,yes,No,no,NO,SI,SÍ
            if (s.equals("1") || s.startsWith("s") || s.startsWith("S")
                    || s.startsWith("y") || s.startsWith("Y")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     *  Funcion que pasa de una cadena a un numero 
     *  
     *  @param CadNum Cadena que queremos pasar a un numero 
     *  @param base Es la base del numero que queremos pasar 
     *  @returnDevuelve el numero en la base solicitada
     *  Pasa una cadena de numeros en base hexadecimal a un numero en base decimal */
    public static int string2int(String CadNum, int base) {
        int Num = 0;
        int i = 0;
        int tamano = 0;
        int aux = 0;
        Num = 0;
        tamano = CadNum.length();
        for (i = 0; i < tamano; i++) {
            if (((CadNum.charAt(i) + "").equalsIgnoreCase("A"))
                    || ((CadNum.charAt(i) + "").equalsIgnoreCase("B"))
                    || ((CadNum.charAt(i) + "").equalsIgnoreCase("C"))
                    || ((CadNum.charAt(i) + "").equalsIgnoreCase("D"))
                    || ((CadNum.charAt(i) + "").equalsIgnoreCase("E"))
                    || ((CadNum.charAt(i) + "").equalsIgnoreCase("F"))) {
                aux = char2hex(CadNum.charAt(i));
            } else {
                aux = Integer.parseInt(CadNum.charAt(i) + "");
            }
            Num = (Num * base) + aux;
        }
        return Num;
    }

    /**
     *  Devuelve El valor del Caracter hexadecimal en un numero decimal
     *  
     *  @param chr Numero de base Hexadecimal en formato String 
     *  @return
     *  Devuelve el valro en base decimal */
    public static int char2hex(char chr) {
        int num = 0;
        String cad = chr + "";
        if (cad.equalsIgnoreCase("A")) {
            num = 10;
        } else if (cad.equalsIgnoreCase("B")) {
            num = 11;
        } else if (cad.equalsIgnoreCase("C")) {
            num = 12;
        } else if (cad.equalsIgnoreCase("D")) {
            num = 13;
        } else if (cad.equalsIgnoreCase("E")) {
            num = 14;
        } else if (cad.equalsIgnoreCase("F")) {
            num = 15;
        }
        return num;
    }
    
    /**
     * Return a String, of length 1, from a char
     * @param c char
     * @return String
     */
    public static String char2string(char c) {
        return c+"";   
    }
    
}
