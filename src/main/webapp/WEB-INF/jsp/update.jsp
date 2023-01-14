<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" modelAttribute="expense"><!-- As we are passing Expense object directly we need to add this modelattribute with 
		its object name this feature is included with form: from spring boot for path always give expense models var name starting with lowercase
		irrespective of its original name-->
		<!-- this method=post hides things from url -->
		<fieldset class="form-group">
			<form:label path="credit">Credit:</form:label> <form:input type="number" path="credit" class="form-control" disabled="true" /><!-- path is replacement of name="" and should match Expense model vars -->
		</fieldset>
		<fieldset class="form-group">
			<form:label path="debit">Debit:</form:label> <form:input type="number" path="debit" class="form-control" disabled="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="foor">For:</form:label> <form:select path="foor" class="form-control">
				<option value="H">H</option>
				<option value="self">self</option>
				<option value="-">-</option>
			</form:select>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="reason">Reason:</form:label> <form:input type="text" path="reason" class="form-control"/>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="date">Date:</form:label> <form:input type="text" path="date" class="form-control" autocomplete="off"/>
		</fieldset>
		<button type="submit" class="btn btn-success">Update</button>
	</form:form>
</div> 
<%@ include file="common/footer.jspf"%>