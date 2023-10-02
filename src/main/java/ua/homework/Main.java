package ua.homework;

import ua.homework.additionalFields.*;
import ua.homework.database.Database;
import ua.homework.request.DatabaseQueryService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Кожен запит виконуєтся окремо

        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectCountClients) {
            System.out.println("Client: " + client.getName() + ", Project Count: " + client.getProjectCount());
        }

        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        for (MaxSalaryWorker worker: maxSalaryWorkers) {
            System.out.println("Name: " + worker.getName() + ", Salary:" + worker.getSalary());
        }

        List<LongrestProject> longrestProjects = new DatabaseQueryService().findLongrestProject();
        for (LongrestProject project : longrestProjects) {
            System.out.println("Client Name: " + project.getClientName() + ", Month Counts: " + project.getMonthCounts());
        }

        List<YongestEldestWorkers> yongestEldestWorkers = new DatabaseQueryService().findYongestEldestWorkers();
        for (YongestEldestWorkers workers : yongestEldestWorkers) {
            System.out.println("Type: " + workers.getType() + " , Name: " + workers.getName() + " , Birthday: " + workers.getBirthday());
        }

        List<PrintProjectPrices> price = new DatabaseQueryService().findProjectPrices();
        for (PrintProjectPrices prices : price) {
            System.out.println("Client Name: " + prices.getClientName() + " , Price: " + prices.getPrice());
        }
    }
}