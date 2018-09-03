package ru.geekbrains.anronelenberger.homework6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLTable {
    public static void main(String[] args) {
        SQLTable sqlTable = new SQLTable();
        try {
            sqlTable.connect();
            sqlTable.createTable();
            sqlTable.insert("Bob1",11);
            sqlTable.insert("Bob2",15);
            sqlTable.insert("Bob3",19);
            sqlTable.insert("Bob4",22);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sqlTable.disconnect();
        }
        try {
            System.out.println(sqlTable.read());
            sqlTable.read();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;
    private static Statement statement;

    public void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:students.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        connect();
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Students\n" +
                    "(\n" +
                    "idStudent INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                    "FirstName TEXT NOT NULL,\n" +
                    "Mark INTEGER NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public String insert(String firstName, int mark) throws SQLException {
        connect();
        List<String> strings = new ArrayList<>();
        String sql = String.format("INSERT INTO Students (FirstName, Mark)\n" +
                "VALUES ('%s',%s)", firstName,mark);
        ResultSet rs = statement.executeQuery(sql);
        try {
            statement.execute(sql);
            while (rs.next()) {
                strings.add(rs.getString(2));
            }
            return strings.get(strings.size()-1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    public String read() throws SQLException {
        connect();
        String sql = String.format("SELECT * FROM STUDENTS");
        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }


    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
