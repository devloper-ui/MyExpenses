<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<table class="table table-bordered table-striped">
		<caption>
			Results for 
		</caption>

		<thead class="thead-light">
			<tr>
				<th>Credit</th>
				<th>Debit</th>
				<th>For</th>
				<th>Reason</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${expenses}" var="expense">
				<tr>
					<td>${expense.credit}</td>
					<!-- use in small case irrespective of model values-->
					<td>${expense.debit}</td>
					<td>${expense.foor}</td>
					<td>${expense.reason}</td>
					<td>${expense.date}</td>
				</tr>
			</c:forEach>
			<!-- for(Expense expense: expenses) since its html it does
							not worry about first expense we can give any name in var -->
		</tbody>
	</table>

</div>
<%@ include file="common/footer.jspf"%>