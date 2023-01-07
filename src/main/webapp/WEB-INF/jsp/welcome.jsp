<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	Welcome ${name}!! <br>
	<br>
	<div class="panel panel-info">
		<div class="panel-heading" style="margin: 40px;">
			<a href="/insertData">Insert Expense(s)</a>
		</div>
		<div class="panel-heading" style="margin: 40px;">
			<a href="/displayData">Show Expenses</a>
		</div>
		<div class="panel-heading" style="margin: 40px;">
			<a href="/getBalance">Show Balance</a>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>