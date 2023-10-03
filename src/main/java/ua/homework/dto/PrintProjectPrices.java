package ua.homework.dto;

public class PrintProjectPrices {

    private String clientName;
    private int price;

    public PrintProjectPrices (String clientName, int price) {

        this.clientName = clientName;
        this.price = price;
    }


    public String getClientName() {
        return clientName;
    }

    public int getPrice() {
        return price;
    }
}
