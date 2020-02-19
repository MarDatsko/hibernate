package com.homework.library.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userNAme")
    private String userName;

    @OneToMany(mappedBy = "owner")
    private Set<Book> setBook;

    public User(String userName) {
        this.userName = userName;
    }
}
