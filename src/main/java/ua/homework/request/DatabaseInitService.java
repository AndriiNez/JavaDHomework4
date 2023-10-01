package ua.homework.request;

import ua.homework.database.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;


public class DatabaseInitService {
    private static final String PATH_INIT_DB_SQL = "./sql files/init_db.sql";

    public static void main(String[] args) {
        try {

            Connection conn = Database.getInstance().getConnection();
            Statement st = conn.createStatement();


            String sql = String.join("\n", Files.readAllLines(Paths.get(PATH_INIT_DB_SQL)));

            st.executeUpdate(sql);


            st.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


