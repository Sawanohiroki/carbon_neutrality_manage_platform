package com.book.service.impl;

import com.book.dao.PolicyMapper;
import com.book.entity.*;
import com.book.service.PolicyService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class PolicyServiceImpl implements PolicyService {

    @Override
    public List<Policy> getPolicyList() {
        try (SqlSession sqlSession = MybatisUtil.getSession()){
            PolicyMapper mapper = sqlSession.getMapper(PolicyMapper.class);
            return mapper.getPolicyList();
        }
    }

//    @Override
//    public void returnBook(String id) {
//        try (SqlSession sqlSession = MybatisUtil.getSession()){
//            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//            mapper.deleteBorrow(id);
//        }
//    }
//
//    @Override
//    public List<Book> getActiveBookList() {
//        Set<Integer> set = new HashSet<>();
//        this.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));
//        try (SqlSession sqlSession = MybatisUtil.getSession()){
//            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//            return mapper.getBookList()
//                    .stream()
//                    .filter(book -> !set.contains(book.getBid()))
//                    .collect(Collectors.toList());
//        }
//    }
//
//    @Override
//    public Map<Book, Boolean> getBookList() {
//        Set<Integer> set = new HashSet<>();
//        this.getBorrowList().forEach(borrow -> set.add(borrow.getBook_id()));
//        try (SqlSession sqlSession = MybatisUtil.getSession()){
//            Map<Book, Boolean> map = new LinkedHashMap<>();
//            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//            mapper.getBookList().forEach(book -> map.put(book, set.contains(book.getBid())));
//            return map;
//        }
//    }
//
//    @Override
//    public List<Student> getStudentList() {
//        try (SqlSession sqlSession = MybatisUtil.getSession()){
//            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//            return mapper.getStudentList();
//        }
//    }
//
    @Override
    public void insertPolicy(String name, String scope1, String scope2, String scope3, String description, Date date) {
        try (SqlSession sqlSession = MybatisUtil.getSession()){
            PolicyMapper mapper = sqlSession.getMapper(PolicyMapper.class);
            mapper.insertPolicy(name, scope1, scope2, scope3, description, date);
        }
    }
//
//    @Override
//    public void deleteBook(int bid) {
//        try (SqlSession sqlSession = MybatisUtil.getSession()){
//            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//            mapper.deleteBook(bid);
//        }
//    }
//
//    @Override
//    public void addBook(String title, String desc, double price) {
//        try (SqlSession sqlSession = MybatisUtil.getSession()){
//            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//            mapper.addBook(title, desc, price);
//        }
//    }
}
