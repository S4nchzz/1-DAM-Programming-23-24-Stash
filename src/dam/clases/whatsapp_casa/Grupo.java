package dam.clases.whatsapp_casa;

import java.util.Scanner;

/**
 * Esta clase tiene una arrayt de objetos de la clase esAdmin la cual
 * contiene todos los usuarios del grupo al que pertenece con un atributo
 * booleano que se refiere los permisos que tiene el usuario en cuestion
 * (true = administrador \ false = noAdministrador), tambien tiene un array
 * de objetos con una referencia a la misma clase para poder tener
 * maniobrabilidad a
 * la hora de añadir usuarios en el sistema, haciendo que este ultimo array
 * nombrado permita guardar los valores del array de objetos con los datos
 * de todos los usuarios en si mismo para poder redimensionar el array
 * principal donde se ejecuta gran parte del codigo.
 * 
 * Explicacion de utilidad de los 2 arrays de objetos: El array 1 tiene los
 * datos
 * de cada usuario, por defecto este array se inicializa en 1 para poder agregar
 * un
 * usuario base, una vez se añada, se cambiara el tamaño del array principal,
 * esto
 * se hace cambiando el puntero de referencia del array saveAdminData por el de
 * esAdmin
 * (saveAdminData = esAdmin) de esta manera este ultimo estaria apuntando a la
 * misma
 * posicion de memoria que el otro vector, una vez se ha cambiado la referencia,
 * se
 * crea un nuevo vector/array con el mismo nombre que tenia el array principal
 * con
 * para poder reemplazarlo pero esta vez aumentando +1 el tamaño antiguo que
 * tenia,
 * esto se codifica de esta manera (saveAdminData = esAdmin; esAdmin = new
 * EsAdmin[saveAdminData + 1])
 * de esta forma ya se tendria el array principal con un tamaño adecuado, solo
 * queda
 * cambiar la referencia, ya que el nuevo array que hemos creado no tiene los
 * datos de los
 * usuarios, por esto debemos "copiar y pegar" los datos de un vector a otro,
 * esto se hace
 * iterando hasta el array de menor longitud y copiando cada posicion con la
 * otra.
 * 
 * 
 * @author Iyan Sanchez
 */
public class Grupo {
    private EsAdmin[] esAdmin;
    private EsAdmin[] saveAdminData;
    private int punteroPosArrOnFirstNull;

    /**
     * Constructor Grupo el cual establece el array de objetos de esAdmin en 1 para
     * poder
     * agregar uno por defecto, tambien se crea un nuevo array para guardar los
     * valores
     * agregados anteriormente en el array esAdmin principal; El atributo
     * punteroPosArrOnFirstNull
     * se actualiza cada vez que se añde un usuario nuevo, este puntero siempre
     * estara en la
     * primera posicion del array de objetos que este en null.
     */
    public Grupo(Persona admin) {
        esAdmin = new EsAdmin[2];
        esAdmin[0] = new EsAdmin(admin, true);
        saveAdminData = new EsAdmin[esAdmin.length];
        punteroPosArrOnFirstNull = 1;
    }

    /**
     * Cuando se hace una llamada a este metodo se guarda la referencia del array
     * principal en una array
     * secundario llamado saveAdminData, luego se crea un array nuevo con el mismo
     * nombre que el principal
     * con una longitud igual al array de guardado de datos + 1, despues de esto se
     * "copian y pegan" los datos
     * de la referencia del array de guardado de datos en el nuevo, debido a que el
     * nuevo array esAdmin que reemplaza
     * al anterior esta "vacio".
     * 
     * @return Array modificado
     */

    private EsAdmin[] biggerSizeArray() {
        saveAdminData = esAdmin;
        esAdmin = new EsAdmin[saveAdminData.length + 1];

        for (int i = 0; i < saveAdminData.length; i++) {
            esAdmin[i] = saveAdminData[i];
        }
        return esAdmin;
    }

    /**
     * Metodo creado para que cuando se elimina un usuario de la lista que esta se
     * haga mas pequeña
     * 
     * @return Array modificado
     */
    private EsAdmin[] lowestSizeArray() {
        saveAdminData = esAdmin;
        esAdmin = new EsAdmin[saveAdminData.length - 1];

        for (int i = 0; i < esAdmin.length; i++) {
            esAdmin[i] = saveAdminData[i];
        }
        return esAdmin;
    }

    /**
     * Se añade una persona elegia por el parametro p de clase Persona, cuando se
     * hace una llamada
     * a este metodo se hace una llamada a biggerSizeArray para aumentar las
     * posiciones del array principal
     * para poder tener el usuario en el array y otra casilla null para poder
     * agregar nuevos usuarios
     * al grupo, una vez hecho esto, en la primera posicion null
     * (punteroPosArrOnFirstNull) se añade
     * un nuevo objeto en esa posicion null del array de objetos con el parametro de
     * la clase persona
     * obtenido, antes de esto hay que saber que en el momento que se aumenta la
     * posicion del array
     * principal quedan 2 posiciones null, la ultima y la penultima, despues de esto
     * se aumenta la
     * posicion del punteroPosArrOnFirstNull para que este apunte a la ultima
     * posicion del vector.
     * 
     * @param p
     */
    public void addPersona(Persona p) {
        if (buscar(p.getTelfID()) >= 0) {
            return;
        }

        biggerSizeArray();
        esAdmin[punteroPosArrOnFirstNull] = new EsAdmin(p, false);
        punteroPosArrOnFirstNull++;
    }

    /**
     * EL usuario da un telefono que se reconoce en el sistema con su ID, como
     * primera funcion
     * se usa try catch para ver si el telefono se encuentra en el sistema, si no lo
     * encuentra haciendo
     * una llamada a buscar(telefono) esta retornara -1, y cuando el sistema intente
     * encontrar un telefono
     * partiendo desde la posicion -1 que es lo que retorna la busqueda ya que no
     * encuentra el telefono
     * esto sera recogido por la funcion catch que obtendra una excepcion
     * ArrayOutOfBoundsException e
     * dentro de esta misma funcion catch se hara un if para ver si contiene -1
     * haciendo uso de los metodos
     * e.getMessage() que obtiene el mensaje del error y seguido .contains("-1")
     * para ver si contiene -1 en el
     * el error, cuando esto pase, se escribira por salida estandar Error: El número
     * de teléfono no existe,
     * ¿desea salir del programa? (S/N), si el usuario elige la opcion S || s el
     * programa se cerrara haciendo
     * uso de System.exit(0), el usuario podra ingresar tanto S mayuscula como s
     * minuscula, debido a que el while
     * hace uso del metodo .equalsIgnoreCase el cual ignora las mayusculas y
     * minusculas, si el usuario elige N || n
     * el programa continuara, (solo podra elegir una de estas dos caracteres
     * ignorando las mayusculas y minusculas como
     * anterior mense se ha dicho) cuando este continue preguntara el numero del
     * usuario que quiere que se elimine y hara
     * una llamada recursiva a si mismo intentando realizar la misma operacion dando
     * como resultado un bucle infinito si no
     * escribe por entrada estandar un numero asociado correctamente a un usuario
     * del grupo; Cuando el numero de telefono
     * asociado concuerde con alguno guardado en el sistema se cambiara, este
     * analisis se hace dentro de la funcion try si se encuentra
     * no entrara en el catch, es decir, el try intenta cambiar un numero de
     * telefono de un usuario haciendo una llamada a buscar
     * si lo encuentra lo cambia por el valor del final que no sea null y el ultimo
     * lo pone en null, todo esto restando - 1 a
     * punteroPoArrOnFirstNull ya que como se explico se elimina un usuario.
     * 
     * @param telefono
     */
    public void deletePersona(String telefono) {
        try {
            esAdmin[buscar(telefono)] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            if (e.getMessage().contains("-1")) {
                System.out.println("Error: El número de teléfono no existe, ¿desea salir del programa? (S/N)");
                Scanner sc = new Scanner(System.in);

                String response = sc.next();

                while (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("N"))) {
                    System.out.println("Valor introducido incorrecto, intentelo de nuevo (S/N): ");
                    response = sc.nextLine();
                }

                if (response.equalsIgnoreCase("S")) {
                    System.exit(0);
                } else {
                    System.out.println("Escriba el numero de telefono del usuario a ser eliminado");
                    String telf = sc.next();
                    deletePersona(telf);
                }
            }
        }
        movimientosUsuarios();
        punteroPosArrOnFirstNull--;
    }

    /**
     * Este metodo es llamado por deletePersona el cual manda un array de objetos
     * con nulls entre valores dados,
     * es decir, en el array [esAdmin, esAdmin, null, esAdmin, null] el metodo
     * moveria el penultimo valor a la
     * posicion anterior null para asi tener una estructura mas organizada. Despues
     * hace una llamada a
     * lowestSizeArray para disminuir la cantida de nulls que deberian de haber,
     * debido a que con este
     * movimiento habrian 2 nulls y el puntero no funcionaria correctamente.
     * 
     * @return
     */
    private EsAdmin[] movimientosUsuarios() {
        for (int i = 0; i < esAdmin.length - 1; i++) {
            if (esAdmin[i] == null && esAdmin[i + 1] != null) {
                esAdmin[i] = esAdmin[i + 1];
                esAdmin[i + 1] = null;
            }
        }
        lowestSizeArray();
        return esAdmin;
    }

    /**
     * Este metodo obtiene un parametro telefono el cual se encarga de buscar este
     * mismo haciendo
     * uso de un bucle que recorre la longitud completa del array y en cada posicion
     * analiza el numero
     * haciendo llamadas a .getPersona, que obtiene el nombre y el telefono de la
     * persona de esa posicion
     * en concreto del vector, .getTelfID que obtiene el telefono de esta persona en
     * cuestion y .equals
     * para comparar el String que tiene de numero de telefono el usuario y el que
     * queremos comprobar
     * 
     * @param telefono
     * @return Posicion en la que se encuentra este usuario, si no lo encuentra
     *         retorna -1
     */
    public int buscar(String telefono) {
        for (int i = 0; i < esAdmin.length - 1; i++) {
            if (esAdmin[i].getPersona().getTelfID().equals(telefono)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Esta funcion obtiene el parametro telf y un booleano newAdminOrNot, est a
     * funcion hace una llamada
     * a buscar con el telefono y si lo encuentra por el sistema retorna la posicion
     * en la cual tiene que
     * buscar el metodo para poder seguir con la ejecucion, en caso contrario
     * retornara -1, esto hara un catch
     * al error ArrayOutOfBoundsException el cual tendra un if dentro de si mismo
     * para ver si gracias a los metodos
     * .getMessage() para obtener el mesanje y .equalsIgnoreCase para ignoral si el
     * usuario escribe S || N en
     * mayusculas o minusculas, si el usuario elige S, se cerrara el programa, en
     * caso contrario proseguira y preguntara
     * de nuevo el telefono del usuario al que quiere cambiar el estado (EL programa
     * no continuara hasta que el usuario
     * escriba correctamente S || s || N || n) cuando esto ocurra, se pedira el
     * nuevo telefono por pantalla y se haran
     * llamadas recursivas para asi poder elegir un usuario correcto con su numero
     * de telf y un valor booleano para poner
     * el usuario con permisos administrador o no.
     * 
     * @param telf
     * @param newAdminOrNot
     */

    public void setEstado(String telf, boolean newAdminOrNot) {
        try {
            esAdmin[buscar(telf)].setEstadoEsAdmin(newAdminOrNot);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (e.getMessage().contains("-1")) {
                System.out.println("Error: El número de teléfono no existe, ¿desea salir del programa? (S/N)");
                Scanner sc = new Scanner(System.in);

                String response = sc.next();

                while (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("N"))) {
                    System.out.println("Valor introducido incorrecto, intentelo de nuevo (S/N): ");
                    response = sc.nextLine();
                }

                if (response.equalsIgnoreCase("S")) {
                    System.exit(0);
                } else {
                    System.out.println("Escriba el numero de telefono del usuario para cambiarle los permisos");
                    telf = sc.next();
                    setEstado(telf, newAdminOrNot);
                }
            }
        }
    }

    /**
     * Metodo que retorna 2 si el usuario que se busca es administrador haciendo uso
     * del metodo
     * .getEstado, si no, retornara 1 si es != null es que un usuario se encuentra
     * en el sistema pero no es
     * administrador, y como ultima opcion retorna 0 si el usuario elegido no existe
     * en el sistema
     * 
     * @param telefono
     * @return Si es administrador existe o no existe
     */

    // Funcion hecha sin hacer uso de try catch
    public int pertenece(String telefono) {
        boolean estaEnArr = buscar(telefono) != -1 ? true : false;

        if (estaEnArr) {
            if (esAdmin[buscar(telefono)].getEstado()) {
                return 2;
            } else if (esAdmin[buscar(telefono)] != null) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * Retornara el array completo esAdmin
     * 
     * @return
     */

    public EsAdmin[] miembros() {
        return esAdmin;
    }

    /**
     * Este metodo cuenta los administradores que existen en el sistema, crea un
     * array de
     * esa longitud, y despues poner los valores de un array en otro para retornar
     * el array
     * nuevo con solo administradores
     * 
     * @return un array con SOLO los administradores
     */
    public EsAdmin[] administradores() {
        int arrAdmin = 0;
        for (int i = 0; i < punteroPosArrOnFirstNull; i++) {
            if (esAdmin[i].getEstado()) {
                arrAdmin++;
            }
        }

        EsAdmin[] administradores = new EsAdmin[arrAdmin];
        int newArrPointer = 0;

        for (int i = 0; i < punteroPosArrOnFirstNull; i++) {
            if (esAdmin[i].getEstado()) {
                administradores[newArrPointer] = esAdmin[i];
            }
        }

        return administradores;
    }

    /**
     * Simple metodo ToString que dice los miembros y administradores del grupo
     */
    @Override
    public String toString() {
        return "Usuarios: " + miembros() + " // Administradores: " + administradores();
    }
}