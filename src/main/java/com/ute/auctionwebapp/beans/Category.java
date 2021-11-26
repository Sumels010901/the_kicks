package com.ute.auctionwebapp.beans;

public class Category {
    private int catID;
    private String catName;

    public Category(int catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }

    public int getCatID() {
        return catID;
    }

    public String getCatName() {
        return catName;
    }
}
