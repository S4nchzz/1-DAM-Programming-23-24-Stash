package dam.connection_data_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        final String s = sc.nextLine();

        System.out.println(s);

        try {
            final String url = "jdbc:mariadb://127.0.0.1:3310/ajedrez";
            final String sql = "SELECT ID, NOMBRE FROM JUGADOR WHERE NOMBRE LIKE '%" + s + "%'";
            Connection con = DriverManager.getConnection(url, "root","");

            System.out.println(sql); 

            final Statement st = con.createStatement();            
            final ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                System.out.print(r.getInt("ID"));
                System.out.print(" ");
                System.out.println(r.getString("NOMBRE"));
            }

            r.close();
            st.close();
            con.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}