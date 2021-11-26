package com.ute.auctionwebapp.controllers;

import com.ute.auctionwebapp.beans.Item;
import com.ute.auctionwebapp.models.ItemModel;
import com.ute.auctionwebapp.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ItemServlet", value = "/item/*")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/byCat":
                int catId = Integer.parseInt(request.getParameter("id"));
                List<Item> list = ItemModel.findByCatId(catId);
                request.setAttribute("items", list);
                ServletUtils.forward("/views/item/byCat.jsp", request, response);
                break;

            case "/Detail":
                int itemID = Integer.parseInt(request.getParameter("id"));
                Item item = ItemModel.findById(itemID);
                if (item == null) {
                    ServletUtils.redirect("/Home", request, response);
                } else {
                    request.setAttribute("item", item);
                    ServletUtils.forward("/views/item/Detail.jsp", request, response);
                }
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
