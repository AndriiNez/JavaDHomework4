package ua.homework.Services;

public class LongrestProject {
    private String clientName;
    private int monthCounts;

    public LongrestProject(String clientName, int monthCounts) {
        this.clientName = clientName;
        this.monthCounts = monthCounts;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonthCounts() {
        return monthCounts;
    }
}
