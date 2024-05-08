package com.book.service;

import com.book.entity.Policy;

import java.util.Date;
import java.util.List;

public interface PolicyService {
    List<Policy> getPolicyList();
//    void returnBook(String id);
//    List<Book> getActiveBookList();
//    List<Student> getStudentList();
    void insertPolicy(String name, String scope1, String scope2, String scope3, String description, Date date);
//    Map<Book, Boolean> getBookList();
//    void deleteBook(int bid);
//    void addBook(String title, String desc, double price);
}
