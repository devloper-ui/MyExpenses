package com.kunal.springboot.web.springbootfirstwebapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kunal.springboot.web.springbootfirstwebapplication.model.Expense;

@Component
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public int getBalance() {
		
		Expense e1 = expenseRepository.findTopByOrderByIdDesc();
		return e1.getBalance();
	}
	
	public Expense checkCreditOrDebit(int balance, Expense expense) {
		if (expense.getCredit() == 0) {
			expense.setBalance(balance - expense.getDebit());
		} else {
			expense.setBalance(balance + expense.getCredit());
		}
		
		return expense;
	}
	
	public void addExpense(Expense expense) {
		expenseRepository.save(expense);
	}
	
	public Iterable<Expense> retrieveAllRecords(){
		//return expenseRepository.findAll();
		return expenseRepository.findByOrderByIdDesc(); //to get latest record first
	}
	
	public Iterable<Expense> retrieveByReason(String reason){
		return expenseRepository.findByReasonContaining(reason);
	}
	
	//even tough we want just one record we have to use list/iterable
	//as we have a loop for display.jsp
	//	public Iterable<Expense> findByID(int id) {
	//		Iterable<Expense> expense = expenseRepository.findById(id);
	//		return expense;
	//	}
	
	public Expense findByID(int id) {
		return expenseRepository.findById(id);
	}
	
	//transactional and modifying both annotations are needed for dml operations
	@Transactional
	public void updateExpense(Expense expense, int id){		
		System.out.println(expense);
		expenseRepository.updateData(expense.getFoor(), expense.getReason(), expense.getDate(), id);
	}
	
//  public void deleteExpense(String reason) {
//      Iterator<Expense> iterator = expenses.iterator();
//      while (iterator.hasNext()) {
//          Expense expense = iterator.next();
//          if (expense.getReason() == reason) {
//              iterator.remove();
//          }
//      }
//  }

    
}
