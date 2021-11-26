package com.ute.auctionwebapp.beans;

import java.math.BigInteger;

public class Item {
    private int itemID, catID, sellerID;
    private BigInteger startPrice;
    private String itemName, tinyDes, fullDes;

    public Item() {
    }

    public Item(int itemID, int catID, int sellerID, String itemName, String tinyDes, String fullDes, BigInteger startPrice) {
        this.itemID = itemID;
        this.catID = catID;
        this.sellerID = sellerID;
        this.itemName = itemName;
        this.tinyDes = tinyDes;
        this.fullDes = fullDes;
        this.startPrice = startPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public int getCatID() {
        return catID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getTinyDes() {
        return tinyDes;
    }

    public String getFullDes() {
        return fullDes;
    }

    public BigInteger getStartPrice() {
        return startPrice;
    }
}
