package com.kunal.springboot.web.springbootfirstwebapplication.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kunal.springboot.web.springbootfirstwebapplication.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Integer>{
	Expense findTopByOrderByIdDesc();
	List<Expense> findByReasonContaining(String Reason);
	List<Expense> findByOrderByIdDesc();
}
