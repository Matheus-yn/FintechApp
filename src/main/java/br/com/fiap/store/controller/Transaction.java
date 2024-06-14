package br.com.fiap.store.controller;

public class Transaction {
    private int amount;
    private String date;
    private String time;
    private String name;
    private String type;
    
    public Transaction(int amount, String date, String time, String name, String type) {
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.type = type;
        this.name = name;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}