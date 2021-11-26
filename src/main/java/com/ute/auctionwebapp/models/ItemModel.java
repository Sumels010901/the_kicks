package com.ute.auctionwebapp.models;

import com.ute.auctionwebapp.beans.Item;
import com.ute.auctionwebapp.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class ItemModel {
    public static List<Item> findAll() {
        final String query = "select * from item";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Item.class);
        }
    }

    public static List<Item> findByCatId(int catID) {
        final String query = "select * from item where catID = :catID";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("catID", catID)
                    .executeAndFetch(Item.class);
        }
    }

    public static Item findById(int id) {
        final String query = "select * from item where itemID = :itemID";
        try (Connection con = DbUtils.getConnection()) {
            List<Item> list = con.createQuery(query)
                    .addParameter("itemID", id)
                    .executeAndFetch(Item.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }

    public static void add(Item p) {
        String insertSql = "INSERT INTO item (itemName, tinyDes, fullDes, itemID, sellerID, catID) VALUES (:itemName, :tinyDes, :fullDes, :itemID, :sellerID, :catID)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("itemName", p.getItemName())
                    .addParameter("tinyDes", p.getTinyDes())
                    .addParameter("fullDes", p.getFullDes())
                    .addParameter("itemID", p.getItemID())
                    .addParameter("catID", p.getCatID())
                    .addParameter("sellerID", p.getSellerID())
                    .executeUpdate();
        }
    }

    public static void update(Item p) {
        String sql = "UPDATE item SET  itemName = :itemName, tinyDes = :tinyDes, fullDes = :fullDes, catID = :catID, sellerID = :sellerID WHERE itemID = :itemID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("itemName", p.getItemName())
                    .addParameter("tinyDes", p.getTinyDes())
                    .addParameter("fullDes", p.getFullDes())
                    .addParameter("itemID", p.getItemID())
                    .addParameter("catID", p.getCatID())
                    .addParameter("sellerID", p.getSellerID())
                    .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from item where itemID = :itemID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("itemID", id)
                    .executeUpdate();
        }
    }
}