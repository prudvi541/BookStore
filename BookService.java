package com.bookStore.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookStore.bookStore.entity.book;
import com.bookStore.bookStore.repository.bookRepository;
import java.util.List;
@Service
public class BookService {
    @Autowired
	bookRepository bookrepository;
    
    
    
    public void save(book b) {
    	bookrepository.save(b);
    }


	public List<book> getallBooks() {
		
		return bookrepository.findAll();
	}
	public book getBookId(int id) {
		return bookrepository.findById(id).get();
	}


	public void deleteById(int id) {
		// TODO Auto-generated method stub
		bookrepository.deleteById(id);
		
	}
	
}
