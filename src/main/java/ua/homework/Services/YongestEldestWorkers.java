package ua.homework.Services;

public class YongestEldestWorkers {
    private String type;
    private String name;
    private String birthday;

    public YongestEldestWorkers (String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }
    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
}
