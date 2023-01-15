<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<table class="table table-bordered table-striped">
		<caption>
			Expenses_
			<script>
				document.write(new Date().getFullYear())
			</script>
			<a class="btn btn-info" href="/insertData" style="float: right">Add
				Expense</a> <span style="float: right">&nbsp&nbsp</span> <a
				class="btn btn-info" href="/getBalance" style="float: right">Show
				Balance</a>
		</caption>

		<thead class="thead-light">
			<tr>
				<th>Credit</th>
				<th>Debit</th>
				<th>For</th>
				<th>Reason</th>
				<th>Date</th>
				<th>Update/Delete</th>
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
					<td class="col-md-2">
					<a class="btn btn-success"
						href="/updateData/${expense.id}"> 
						<span data-toggle="tooltip"
							title="Update data" class="glyphicon glyphicon-refresh"
							data-placement="right">
						</span>
					</a> 
					<a class="btn btn-danger" href="/deleteData/${expense.id}"
						style="pointer-events: none; cursor: default;"> 
						<span
							data-toggle="tooltip" title="Delete Data"
							class="glyphicon glyphicon-trash" 
							data-placement="right">
						</span>
					</a>
					</td>
				</tr>
			</c:forEach>
			<!-- for(Expense expense: expenses) since its html it does
							not worry about first expense we can give any name in var -->
		</tbody>
	</table>

</div>
<%@ include file="common/footer.jspf"%>