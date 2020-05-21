<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">
		<div class="container">
			<section>
				<div class="jumbotron">
					<div class="container">
						<h1>Customer registered successfuly !</h1>
					
					</div>
				</div>
			</section>
			<section class="container">				
					<p>
						<a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
					</p>
			</section>
		</div>
</div>

	<!-- include file angularJS -->	
<script src="<c:url value="/resources/controller.js"/>"></script>
<%@include file="/WEB-INF/view/template/footer.jsp" %>	  