package tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;

public class AccountDAO {

    private static final String connectDB = "jdbc:derby//localhost:1527/mydb";

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Connection conn = null;

        try {
            conn = dao.connect();
            System.out.println("conn = " + conn);
            Random random = new Random();
            int tempKey = random.nextInt();
            dao.insertData(conn, "godofjava", "god");
            dao.selectAllData(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public Connection connect() throws Exception {
        Connection conn = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        conn = DriverManager.getConnection(connectDB);

        return conn;
    }

    public void insertData(Connection conn, String id, String password) {
        PreparedStatement statement = null;
        try {
            String sql = "insert into account values(?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, password);
            int result = statement.executeUpdate();
            System.out.println("result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void selectAllData(Connection conn) {
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            String sql = "select id , password from account";
            rs = statement.executeQuery(sql);
            int index = 0;
            while (rs.next()) {
                String id = rs.getString(1);
                String password = rs.getString(2);
                System.out.println("password = " + password);
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        }
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
