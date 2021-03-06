<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="items" scope="request" type="java.util.List<com.ute.auctionwebapp.beans.Item>"/>

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                Danh mục sản phẩm
            </h4>
            <c:choose>
                <c:when test="${items.size() == 0}">
                    <div class="card-body">
                        <p class="card-text">Không có dữ liệu.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-body">
                        <div class="row">
                            <c:forEach items="${items}" var="c">
                                <div class="col-sm-4 mb-3">
                                    <div class="card h-100">
                                        <img src="${pageContext.request.contextPath}/public/img/sanpham/${c.itemID}/main_thumbs.jpg"
                                             alt="${c.itemName}" title="${c.itemName}" class="card-img-top">
                                        <div class="card-body">
                                            <h6 class="card-title">${c.itemName}</h6>
                                            <h5 class="card-title text-danger">
                                                <fmt:formatNumber value="${c.startPrice}" type="number"/>
                                            </h5>
                                            <p class="card-text">${c.tinyDes}</p>
                                        </div>
                                        <div class="card-footer text-muted">
                                            <a class="btn btn-sm btn-outline-primary"
                                               href="${pageContext.request.contextPath}/item/Detail?id=${c.itemID}"
                                               role="button">
                                                <i class="fa fa-eye" aria-hidden="true"></i>
                                                Details
                                            </a>
                                            <a class="btn btn-sm btn-outline-success" href="#" role="button">
                                                <i class="fa fa-cart-plus" aria-hidden="true"></i>
                                                Add to cart
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</t:main>