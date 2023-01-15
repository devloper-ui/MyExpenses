package com.kunal.springboot.web.springbootfirstwebapplication.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kunal.springboot.web.springbootfirstwebapplication.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Integer>{
	Expense findTopByOrderByIdDesc();
	List<Expense> findByReasonContaining(String Reason);
	List<Expense> findByOrderByIdDesc();
	//List<Expense> findById(int id);
	Expense findById(int id);
	
	//for update operation problem solved by keeping return type null
	//with any other return type it gives error as no ddl/dml operation can be performed
	@Modifying(clearAutomatically = true)
	@Query("update Expense e set e.Foor= :Foor, e.reason= :reason, e.Date= :Date where e.id= :id")
	void updateData(String Foor, String reason, String Date, int id);
	
}
