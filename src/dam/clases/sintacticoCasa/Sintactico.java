package dam.clases.sintacticoCasa;

public class Sintactico {
    private String tokkenSinEspacios;

    /**
     * Constructor que establece la variable tokkenSinEspacios = ""
     */
    public Sintactico() {
        this.tokkenSinEspacios = "";
    }

    /**
     * Llamada al constructor por defecto para inicializar la variable tokkenSinEspacios = ""
     * Se establece tokkenSinEspacios haciendo una llamada al metodo removeSpaces con el @param tokkenUer
     * @param tokkenUser Parametro de la operacion matematica que importa el usuario
     */
    public Sintactico(String tokkenUser) {
        this(); // ? Llama al constructor por defecto
        this.tokkenSinEspacios = removeSpaces(tokkenUser);
    }

    /**
     * 
     * @return Retorna tokkenSinEspacios
     */
    public String getString() {
        return tokkenSinEspacios;
    }

    /**
     * 
     * @return Retorna true si los metodos llamados tambien son true, es decir, si los parenteis estan
     * bien colocados devolvera true, a su vez, el metodo comprobacionOperandos devolvera true si los 
     * operando estan bien colocados. Si alguna de estas condiciones no se cumplen devolvera false
     */
    public boolean getLexico() {
        return comprobacionParentesis() && comprobacionOperandos();
    }

    /**
     * Metodo para eliminar los espacios de tokkenUser
     * @param tokkenUser Parametro importado desde el constructor
     * @return
     */
    private String removeSpaces(String tokkenUser) {
        for (int i = 0; i < tokkenUser.length(); i++) {
            if (tokkenUser.charAt(i) != ' ') {
                this.tokkenSinEspacios += tokkenUser.charAt(i);
            }
        }
        return tokkenSinEspacios;
    }

   /**
    * Comprobacion de la apertura de los parentesis y el cerrado de los mismos
    * @return Retorna si los parentesis se cierran correctamente y si no existen
    * excepciones como () = false ||  )( = false
    */
    private boolean comprobacionParentesis() {
        int comprobacionParentesisAbierto = 0;
        int comprobacionParentesisCerrado = 0;
        boolean comprobacionParentesis = false;

        // * Comprobacion del primera posicion
        String checkFirstChar = String.valueOf(tokkenSinEspacios.charAt(0));

        if (checkFirstChar.equals("(") && !checkFirstChar.equals("*") && !checkFirstChar.equals("/")) {
            comprobacionParentesisAbierto++;
        } else if (checkFirstChar.equals(")")) {
            return false;
        }

        // * Comprobacion de la longitud
        // * exceptuando la primera y la ultima posicion
        for (int i = 1; i < tokkenSinEspacios.length() - 1; i++) {
            String lastChar = String.valueOf(tokkenSinEspacios.charAt(i - 1));
            String actualChar = String.valueOf(tokkenSinEspacios.charAt(i));
            String nextChar = String.valueOf(tokkenSinEspacios.charAt(i + 1));

            if (actualChar.equals("(") && !nextChar.matches("[/*)]")) {
                comprobacionParentesisAbierto++;
            } else if (actualChar.equals(")") && !lastChar.matches("[+-/*(]")) {
                comprobacionParentesisCerrado++;
            }

            if (actualChar.equals(")") && comprobacionParentesisAbierto == 0) {
                return false;
            }
        }

        // * Comprobacion de la ultima posicion
        String checkLastChar = String.valueOf(tokkenSinEspacios.charAt(tokkenSinEspacios.length() - 1));

        if (checkLastChar.equals(")") && !checkLastChar.matches("[+-/*]")) {
            comprobacionParentesisCerrado++;
        }

        // * Ultima comprobacionParentesis si los parentesis cerrados y abiertos
        // * coinciden despues de hacer el checking a la ultima posicion
        if (comprobacionParentesisAbierto == comprobacionParentesisCerrado) {
            comprobacionParentesis = true;
        }
        return comprobacionParentesis;
    }

    /**
     * Comprobacion de todas las combinaciones posibles con los operandos comunes [+-/*]
     * haciendo uso de el metodo .matches de la clase String
     * @return Retorna si todoas las combinaciones son correctas o no
     */
    private boolean comprobacionOperandos() {
        String checkFirstChar = String.valueOf(tokkenSinEspacios.charAt(0));
        if (checkFirstChar.matches("[/*)]")) {
            return false;
        }

        // * Si hay dos operandos juntos comprobacionOperandos = flase, 
        // * Ejemplo {**} = false || {*3+1} = false ||(*3-1) = false
        for (int i = 1; i < tokkenSinEspacios.length() - 1; i++) {
            String lastChar = String.valueOf(tokkenSinEspacios.charAt(i - 1));
            String actualChar = String.valueOf(tokkenSinEspacios.charAt(i));
            String nextChar = String.valueOf(tokkenSinEspacios.charAt(i + 1));

            // ? .matches es un metodo de la clase String en cual le podemos añadir 
            // ? caracteres para que devuelva una boolean
            if (actualChar.equals("+") && (lastChar.matches("[+-/*xX]") || nextChar.matches("[+-/*xX)]"))) {
                return false;
            } else if (actualChar.equals("-") && (lastChar.matches("[+-/*xX]") || nextChar.matches("[+-/*xX)]"))) {
                return false;
            } else if ((actualChar.equals("*") || actualChar.equals("x") || actualChar.equals("X"))
                    && (lastChar.matches("[+-/*xX(]") || nextChar.matches("[+-/*xX)]"))) {
                return false;
            } else if ((actualChar.equals("/") || actualChar.equals("*") || actualChar.equals("÷"))
                    && (lastChar.matches("[+-/*xX(]") || nextChar.matches("[+-/*xX)]"))) {
                return false;
            }
        }

        // * Ultima comprobacion
        String finalChar = String.valueOf(tokkenSinEspacios.charAt(tokkenSinEspacios.length() - 1));
        return finalChar.matches("[+-/*()]");
    }
}