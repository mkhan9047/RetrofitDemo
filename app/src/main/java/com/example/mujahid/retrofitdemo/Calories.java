package com.example.mujahid.retrofitdemo;

/**
 * Created by Mujahid on 1/25/2018.
 */

class Calories {

    private String name;
    private int Price;
    private int Calorie;
    private String image_Url;


    public Calories(String name, int price, int calorie, String img_URL) {
        this.name = name;
        this.Price = price;
        this.Calorie = calorie;
        image_Url = img_URL;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return Price;
    }

    public int getCalorie() {
        return Calorie;
    }

    public String getImg_URL() {
        return image_Url;
    }
}
