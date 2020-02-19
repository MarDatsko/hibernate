package com.homework.library.logic;

import com.homework.library.controler.AuthorController;
import com.homework.library.controler.BookController;
import com.homework.library.controler.UserController;
import com.homework.library.entity.Book;
import com.homework.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOperations {

    @Autowired(required = false)
    private UserController userController;

    @Autowired(required = false)
    private AuthorController authorController;

    @Autowired(required = false)
    private BookController bookController;


    public void loginUser(String nickName){
        if(userController.getByUserName(nickName)== null){
            User user = new User(nickName);
            userController.saveOrUpdate(user);
            System.out.println("You have been added to the list ");
        }else {
            System.out.println("Welcome back to our library");
        }
    }

    public void getBook(Long id){
        Book book = bookController.getById(id);
        User user = userController.getByUserName("---------");
    }


}
