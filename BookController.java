package com.bookStore.bookStore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.entity.book;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListService;

@Controller
public class BookController {
	@Autowired
    BookService bookservice;
	
	@Autowired
    MyBookListService booklist;
	
	@GetMapping("/")
	public String gethome() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookregister";
	}
	
	
	
	@GetMapping("/my_books")
	public ModelAndView mybooks() {
		List<MyBookList> list=booklist.getAllBooks();
		return new ModelAndView("mybook","MyBook",list);
	}
	@GetMapping("/available_books")
	public ModelAndView getallBooks() {
		List<book> list=bookservice.getallBooks();
		return new ModelAndView("availablebook","book",list);
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute  book b) {
		bookservice.save(b);
		return "redirect:/available_books";
	}
	@RequestMapping("/mylist/{id}")
	public String getmylist(@PathVariable("id") int id) {
		book b=bookservice.getBookId(id);
		MyBookList boom=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		booklist.save(boom);
		return "redirect:/my_books";
	}
	@RequestMapping("/deleteMyList/{id}")
	public String deleteById(@PathVariable("id") int id) {
		booklist.deleteById(id);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteRecord(@PathVariable("id") int id) {
		bookservice.deleteById(id);
		return "redirect:/available_books";
	}
	@RequestMapping("/editBook/{id}")
	public String update(@PathVariable("id") int id,Model model) {
		book b=bookservice.getBookId(id);
		model.addAttribute("book", b);
		return "editbook";
	}
	

}
