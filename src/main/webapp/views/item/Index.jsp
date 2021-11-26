<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="items" scope="request" type="java.util.List<com.ute.auctionwebapp.beans.Item>"/>

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header d-flex justify-content-between">
                Items (Admin)
                <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Item/Add"
                   role="button">
                    <i class="fa fa-plus" aria-hidden="true"></i>
                    Add Item
                </a>
            </h4>
            <c:choose>
                <c:when test="${items.size() == 0}">
                    <div class="card-body">
                        <p class="card-text">Không có dữ liệu.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Product</th>
                                <th>Desciption</th>
                                <th class="text-right">Price</th>
                                <th class="text-right">Quantity</th>
                                <th>&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${items}" var="c">
                                <tr>
                                    <td>${c.itemID}</td>
                                    <td>${c.itemName}</td>
                                    <td>${c.tinyDes}</td>
                                    <td class="text-right">
                                        <fmt:formatNumber value="${c.tinyDes}" type="number"/>
                                    </td>
                                    <td class="text-right">${c.fullDes}</td>
                                    <td class="text-right">
                                        <a class="btn btn-sm btn-outline-primary"
                                           href="${pageContext.request.contextPath}/Admin/Item/Edit?id=${c.itemID}"
                                           role="button">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</t:main>