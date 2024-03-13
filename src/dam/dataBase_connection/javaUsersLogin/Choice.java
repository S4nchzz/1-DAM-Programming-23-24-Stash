package dam.dataBase_connection.javaUsersLogin;

import java.sql.SQLException;
import dam.dataBase_connection.javaUsersLogin.gestionUsuarios.UserGestion;

public class Choice {
    public static void eleccion(int eleccion) throws SQLException {
        switch (eleccion) {
            case 1:
                UserGestion.anadir();
                break;

            case 2:
                UserGestion.borrar();
                break;

            case 3:
                UserGestion.cambiarContrasena();
                break;

            case 4:
                UserGestion.acceder();
                break;
        }
    }
}