package com.ute.auctionwebapp.models;

import com.ute.auctionwebapp.beans.Category;
import com.ute.auctionwebapp.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class CategoryModel {

    public static List<Category> findAll() {
        final String query = "select * from category";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }

    public static Category findById(int id) {
        final String query = "select * from category where catID = :catID";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .addParameter("catID", id)
                    .executeAndFetch(Category.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }

    public static void add(Category c) {
        String insertSql = "insert into category(catName) values (:catName)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("catName", c.getCatName())
                    .executeUpdate();
        }
    }

    public static void update(Category c) {
        String sql = "update category set catName = :catName where catID = :catID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("catID", c.getCatID())
                    .addParameter("catName", c.getCatName())
                    .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from category where catID = :catID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("catID", id)
                    .executeUpdate();
        }
    }
}
