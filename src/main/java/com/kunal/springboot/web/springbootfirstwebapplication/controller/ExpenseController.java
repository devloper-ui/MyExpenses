package com.kunal.springboot.web.springbootfirstwebapplication.controller;
//if you want you can add diff pages for debit and credit by setting redirect to repesctive pages.
//also add methods to service to check credit and debit what's 0 and then decide whether to add or deduct the balance.

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kunal.springboot.web.springbootfirstwebapplication.model.Expense;
import com.kunal.springboot.web.springbootfirstwebapplication.service.ExpenseRepository;
import com.kunal.springboot.web.springbootfirstwebapplication.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping(value = "/insertData")
	public String displayInsertDataPage(ModelMap model) {
		model.addAttribute("expense", new Expense());
		// this "expense" i.e first attribute will get mapped to modelAttribute
		//at form tag and is needed to show how expense object 
		//looks like so as to pass it directly to a method eg line30,31
		return "insert";
	}
	//while creating post first you need to create get as well for same url.
	@PostMapping(value = "/insertData")
	public String insertData(ModelMap model, Expense expense) {
		int balance = expenseService.getBalance();
		expense = expenseService.checkCreditOrDebit(balance, expense);
		expenseService.addExpense(expense);
		return "redirect:/displayData";
	}

	@GetMapping(value = "/displayData")
	public String displayData(ModelMap model) {
		model.put("expenses", expenseService.retrieveAllRecords());
		return "display";
	}

	@GetMapping(value = "/getBalance")
	public String showBalance(ModelMap model) {
		model.put("balance", expenseService.getBalance());
		return "balance";
	}
		
	@GetMapping(value = "/updateData/{id}")
	public String displayUpdateDataPage(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("expense", expenseService.findByID(id));
		// ^ this "expense" i.e first attribute will get mapped to modelAttribute
		//at form tag and is needed to show how expense object 
		//looks like so as to pass it directly to a method eg line30,31
		return "update";
	}
	
	@PostMapping(value = "/updateData/{id}")
	public String updateData(ModelMap model, Expense expense, @PathVariable("id") int id) {
		expense.setID(id);
		expense.setBalance(expenseService.findByID(id).getBalance());
		expenseService.updateExpense(expense, id);
		return "redirect:/displayData";
	}
	
	
	@GetMapping(value = "/deleteData/{id}")
	public String deleteData(@PathVariable("id") int id) {
		expenseService.deleteExpenseByID(id);
		return "redirect:/displayData";
	}

	@GetMapping(value = "/find/{term}")
	public String getExpenseByReason(ModelMap model, @PathVariable("term") String searchTerm) {
		model.put("expenses", expenseService.retrieveByReason(searchTerm));
		model.put("serachTerm",searchTerm);
		return "search";
	}
}
