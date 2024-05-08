package com.book.service;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    boolean enterprise(String username, String password, HttpSession session);
    boolean government(String username, String password, HttpSession session);
}
