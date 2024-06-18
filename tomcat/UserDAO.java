package tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    private static final String connectDB =
        "jdbc:derby://localhost:1527//mydb";

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        System.out.println(dao.login("godofjava", "god"));
        System.out.println(dao.login("godofjava", "god2"));
    }

    public Connection connect() throws Exception {
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        conn = DriverManager.getConnection(connectDB);
        return conn;
    }

    public boolean login(String id, String password) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            String sql = "select id,password from account " + "where id=? and password=?";
            conn = connect();
            statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, password);
            rs = statement.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, statement, rs);
        }
        return result;
    }

    public void closeAll(Connection conn, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
