package faisal.app1.bootstrap;

import faisal.app1.models.Author;
import faisal.app1.models.Book;
import faisal.app1.models.Publisher;
import faisal.app1.repositories.AuthorRepository;
import faisal.app1.repositories.BookRepository;
import faisal.app1.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//this will be fired when the application starts or reloads


@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {



    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //System.out.println("system startedddd  .................................................. ");
        initData();
    }


    private void initData() {
        Author faisal = new Author("mohammad" , "faisal");
        Publisher publisher = new Publisher("faisal" , "shyamoly");
        Book faisalsBook = new Book("Awesome" , publisher);

        faisal.getBookSet().add(faisalsBook);
        faisalsBook.getAuthorSet().add(faisal);
        faisalsBook.getAuthorSet().add(faisal);

        authorRepository.save(faisal);
        publisherRepository.save(publisher);
        bookRepository.save(faisalsBook);

    }
}
