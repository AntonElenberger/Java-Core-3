package ru.geekbrains.antonelenberger.homework2;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Anton Elenberger
 */

public class App {
    public static Connection connection;
    public static Statement statement;
    public static Scanner scanner;

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:goods.db");
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS items" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "prodid TEXT UNIQUE NOT NULL, " +
                    "title TEXT, " +
                    "price INTEGER)");
            fillTable();
            startWorkWithTable();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e){}
        }
    }

    public static void fillTable() throws SQLException {
        statement.execute("DELETE FROM items");
        connection.setAutoCommit(false);
        for(int i = 1; i <= 1000; i++) {
            String str = String.format("INSERT INTO items (prodid, title, price) " +
                    "VALUES ('id_товара $s', 'товар $s', '$s')",i, i, i*10);
            statement.execute(str);
        }
        connection.setAutoCommit(true);
    }

    public static void startWorkWithTable() {
        scanner = new Scanner(System.in);
        System.out.println("Введите help чтобы узнать доступные команды");
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            if(input.startsWith("/цена товара")) {
                showPrice(input);
            } else if(input.startsWith("/сменитьцену товар")) {
                priceChange(input);
            } else if(input.startsWith("/товарпоцене")) {
                priceRange(input);
            } else if(input.startsWith("/конец")) {
                break;
            } else if(input.startsWith("help")) {
                System.out.println("/сменитьцену товар\n" +
                        "/цена товара\n" +
                        "/товарпоцене\n" +
                        "/конец");
            } else {
                System.out.println("Неверная команда");
                System.out.println("Введите help чтобы узнать доступные команды");
            }
        }
        scanner.close();
    }

    public static void showPrice(String inputStr) {
        String str = String.format("SELECT price FROM items WHERE title = '$s'", inputStr.split("")[1]);
        try {
            ResultSet resultSet = statement.executeQuery(str);
            System.out.println("Цена товара " + inputStr.split("")[1] + " = " + resultSet.getString(1));
        } catch (SQLException e){
            System.out.println("Товар не найден");
        }
    }

    public static void priceChange(String inputStr) {
        String str = String.format("UPDATE items SET price = '$s' WHERE title = '#s'", inputStr.split("")[2], inputStr.split("")[1]);
        try {
            statement.execute(str);
        } catch (SQLException e) {}
        System.out.println("Цена товара " + inputStr.split("")[1] + " = " + inputStr.split("")[2]);
    }

    public static void  priceRange(String inputStr) {
        String str = String.format("SELECT title FROM items WHERE price BETWEEN '#s' AND '$s'", inputStr.split("")[1], inputStr.split("")[2]);
        try {
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {}
    }

}
