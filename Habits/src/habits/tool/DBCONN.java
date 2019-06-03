package habits.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCONN {
    static Connection con = null;

    public static Connection getConnection() {
        if (con != null) return con;

        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn =  DriverManager.getConnection("jdbc:sqlserver://DESKTOP-5MDD5TR\\ZOTASQL:1433;databaseName=HabitsDatabase;", "sa", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con = conn;
        return con;
    }
}