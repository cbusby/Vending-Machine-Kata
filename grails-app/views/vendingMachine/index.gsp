<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Vending Machine</title>
</head>

<body>
	<section>
		<div id="display">${currentStatus}</div>
		<div class="button-container">
			<g:each in="${products}" var="product">
				<div id="${product.id}" class="button">${product.name}</div>
			</g:each>
		</div>
		<div class="coin-return"></div>
	</section>
	<aside>
		<div class="coin-slot"></div>
		<div class="coin-container">
			<g:each in="${coins}" var="coin">
				<div class="coin" data-circumference="${coin.circumference}" data-weight="${coin.weight}">${coin.circumference}</div>
			</g:each>
		</div>
	</aside>
</body>
</html>