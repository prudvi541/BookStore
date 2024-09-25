package com.bookStore.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepository;

@Service
public class MyBookListService { 
	
	@Autowired
	private MyBookRepository mybookrepository;
	
	public void save(MyBookList b) {
		mybookrepository.save(b);
	}
	public List<MyBookList> getAllBooks(){
		return mybookrepository.findAll();
	}
	public void deleteById(int id) {
		mybookrepository.deleteById(id);
	}

}
