package com.example.jpaworkshop.dto;

import com.example.jpaworkshop.entity.Author;
import com.example.jpaworkshop.entity.Book;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    @Setter(AccessLevel.NONE)
    private int id;
    private String firstName;
    private String lastName;
    private Set<BookDTO> bookDTOSet = new HashSet<>();

    public AuthorDTO(Author author) {
        setFirstName(author.getFirstName());
        setLastName(author.getLastName());
        setBookDTOSet(author);
    }

    private void setBookDTOSet(Author author) {
        if (author.getBooks() != null) {
            for (Book book : author.getBooks()) {
                this.bookDTOSet.add(new BookDTO(book));
            }
        }
    }
}
