package dam.dataBase_connection.javaUsersLogin.saltGenerator;

public class Salting {
    public static String saltGenerator() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            sb.append((char) (33 + (int) (Math.random() * 94)));
        }

        return sb.toString();
    }
}
