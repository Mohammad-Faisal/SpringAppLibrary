package faisal.app1.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;

    @OneToOne
//    @JoinColumn(name="publisher_idd" , referencedColumnName = "id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id") ,
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authorSet = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public Book(String title , Publisher publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
