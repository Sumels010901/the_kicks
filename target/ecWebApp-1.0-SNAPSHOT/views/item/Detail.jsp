<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="item" scope="request" type="com.ute.auctionwebapp.beans.Item" />

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                    ${item.itemName}
            </h4>
            <div class="card-body">
                <img src="${pageContext.request.contextPath}/public/img/sanpham/${item.itemID}/main_thumbs.jpg" alt="${item.itemName}" title="${item.itemName}" width="300px" height="300px">
                <p class="card-text mt-3">
                    Giá bán:
                    <span class="text-danger font-weight-bold">
            <fmt:formatNumber value="${item.startPrice}" type="number" />
          </span>
                </p>
                <p class="card-text">Mô tả: ${item.tinyDes}</p>
                <p class="card-text">${item.fullDes}</p>
            </div>
        </div>
    </jsp:body>
</t:main>