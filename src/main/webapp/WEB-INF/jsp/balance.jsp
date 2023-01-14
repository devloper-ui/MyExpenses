<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1 class="text-center"><span class="glyphicon glyphicon-ok"></span></h1>
	<h2 class="text-center">Your Balance is</h2> <hr> 
	<h2 class="text-center">${balance}</h2> <hr>
	<div class="text-center">
		<h3 class="text-center">
		<a href="/" style="color:black; margin-left: 40%; float:left">
			<span class="glyphicon glyphicon-home"></span>
		</a>
		<a href="#" onClick="history.back()" style="color:black; margin-right: 40%; float:right">
			<span class="glyphicon glyphicon-circle-arrow-left"></span>
		</a>
	</h3>
	</div>

</div>
<%@ include file="common/footer.jspf"%>