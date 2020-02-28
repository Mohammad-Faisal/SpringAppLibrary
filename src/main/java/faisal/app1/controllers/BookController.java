package faisal.app1.controllers;


import faisal.app1.models.Book;
import faisal.app1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/books")
    private String getBooksByAuthor(Model model){

        model.addAttribute("books" , bookRepository.findAll());
        return "test";
    }
}
