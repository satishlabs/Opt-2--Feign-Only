package com.booksearchms.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booksearchms.info.BookInfo;
import com.booksearchms.info.BookPriceInfo;
import com.booksearchms.proxy.BookPriceProxy;

@RestController
public class BookSearchController {
	
	@Autowired
	private BookPriceProxy bookPriceProxy;
	
	@GetMapping("/mybook/{bookId}")
	public BookInfo getBookById(@PathVariable Integer bookId) {
		System.out.println("---BookController---getBookById()---: "+bookId); 

		BookInfo bookInfo = new BookInfo(bookId, "Master Spring Boot 2", "Satish", "JLC", "Java"); 
		
		//2.Invoking BookPrice with Feign Only
		BookPriceInfo bookPriceInfo = bookPriceProxy.getBookPrice(bookId);
		bookInfo.setPrice(bookPriceInfo.getPrice());
		bookInfo.setOffer(bookPriceInfo.getOffer());
		bookInfo.setServerPort(bookPriceInfo.getServerPort());
		
		return bookInfo;
		
	}
}
