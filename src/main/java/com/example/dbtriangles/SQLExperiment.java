package com.example.dbtriangles;
import java.sql.*;
import java.util.ArrayList;

public class SQLExperiment {
    void testConnection(){
        String url = "jdbc:postgresql://10.10.104.136:5432/Geometry?user=postgres&password=123";
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Подключено");
        } catch (SQLException e) {
            System.out.println("не удалось подключиться");
            System.out.println(e.getMessage());
        }
    }

    static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://10.10.104.136:5432/Geometry?user=postgres&password=123";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }

    static void saveTriangle(OTriangle otr) throws SQLException {
        //insert into "Triangle" (a, b, c) values (25, 36, 41);
        Connection conn = getConnection();
        double a = otr.getA();
        double b = otr.getB();
        double c = otr.getC();
        String query = "insert into \"Triangle\" (a, b, c) values ("+a+", "+b+", "+c+");";
        Statement st = conn.createStatement();
        st.execute(query);
    }

    static ArrayList<OTriangle> readTriangles() throws Exception {
        ArrayList<OTriangle> trrrr=new ArrayList<>();
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String query ="select a, b, c from \"Triangle\" t ;";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            double a = rs.getDouble("a");
            double b = rs.getDouble("b");
            double c = rs.getDouble("c");
            OTriangle t = new OTriangle(a, b, c);
            trrrr.add(t);
        }
        return trrrr;
    }
}
