package ua.homework.request;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

import ua.homework.additionalFields.*;
import ua.homework.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQueryService {

    private static final String PATH_MAX_PROJECT_CLIENT_SQL = "./sql files/find_max_projects_client.sql";
    private static final String PATH_MAX_SALARY_WORKER_SQL = "./sql files/find_max_salary_worker.sql";
    private static final String PATH_LONGEST_PROJECT_SQL = "./sql files/find_longest_project.sql";
    private static final String PATH_YONGEST_ELDEST_WORKER_SQL = "./sql files/find_youngest_eldest_workers.sql";
    private static final String PATH_PRINT_PROJECT_PRICES_SQL = "./sql files/print_project_prices.sql";


    private <T> List<T> executeQuery(String fileName, ResultSetMapper<T> mapper) {
        List<T> result = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             Statement st = conn.createStatement()) {

            String sql = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            ResultSet resultSet = st.executeQuery(sql);

            while (resultSet.next()) {
                T item = mapper.map(resultSet);
                result.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        return executeQuery(PATH_MAX_PROJECT_CLIENT_SQL, resultSet -> {
            String name = resultSet.getString("name");
            int projectCount = resultSet.getInt("PROJECT_COUNT");
            return new MaxProjectCountClient(name, projectCount);
        });
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        return executeQuery(PATH_MAX_SALARY_WORKER_SQL, resultSet -> {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            return new MaxSalaryWorker(name, salary);
        });
    }

    public List<LongrestProject> findLongrestProject() {
        return executeQuery(PATH_LONGEST_PROJECT_SQL, resultSet -> {
            String clientName = resultSet.getString("CLIENT_NAME");
            int monthCounts = resultSet.getInt("MONTH_COUNT");
            return new LongrestProject(clientName, monthCounts);
        });
    }

    public List<YongestEldestWorkers> findYongestEldestWorkers() {
        return executeQuery(PATH_YONGEST_ELDEST_WORKER_SQL, resultSet -> {
            String type = resultSet.getString("TYPE");
            String name = resultSet.getString("NAME");
            String birthday = resultSet.getString("BIRTHDAY");
            return new YongestEldestWorkers(type, name, birthday);
        });
    }

    public List<PrintProjectPrices> findProjectPrices() {
        return executeQuery(PATH_PRINT_PROJECT_PRICES_SQL, resultSet -> {
            String clientName = resultSet.getString("CLIENT_NAME");
            int price = resultSet.getInt("PRICE");
            return new PrintProjectPrices(clientName, price);
        });
    }
}
