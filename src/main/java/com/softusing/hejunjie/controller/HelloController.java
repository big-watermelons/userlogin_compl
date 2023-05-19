//package com.softusing.hejunjie.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
///*
//　Created by
// */
////@Controller
//@RestController
//@RequestMapping("/api/v2")
//public class HelloController {
//
//    @RequestMapping("/say")
////    @PostMapping("/say")
//    public String hello() {
//        return "hello String Boot";
//    }
//
//
//    @GetMapping("/books")
////    @ResponseBody
//    public Object getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
//
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", "name2");
//        book.put("author", "author2");
//        book.put("isbn", "isbn2");
//
////        Book.put("name", "hello");
////        Book.put("a);
////        return Book;
//
//        Map<String, Object> book2 = new HashMap<>();
//        book2.put("name", "name2");
//        book2.put("author", "author2");
//        book2.put("isbn", "isbn2");
//
//        List<Map> contents = new ArrayList<>();
//        contents.add(book);
//        contents.add(book2);
//
//        Map<String, Object> pagemap = new HashMap<>();
//        pagemap.put("page", page);
//        pagemap.put("size", size);
//        pagemap.put("content", contents);
//
//        return pagemap;
//
//        //        return "books";
//    }
//
//
//    @GetMapping("books/{id}")
//    //getOne
//    public Object getOne(@PathVariable long id) {
//
////        System.out.println("----------id:" + id);
////        Map<String, Object> Book = new HashMap<>();
////        Book.put("name", "互联网");
////        Book.put("isbn", "78654");
////        Book.put("author", "贺俊杰");
//        return null;
//    }
//
//
//    @GetMapping("/books/{id}/{username}")
//    //getOne
//    public Object getOne(@PathVariable long id, @PathVariable String username) {
//
//        System.out.println("----------id:" + id + "username" + username);
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", "hello");
//        book.put("isbn", 18);
//        book.put("username", username);
//        return book;
//
//    }
////
//    public Object post(
//            @RequestParam("name") String name,
//            @RequestParam("author") String author,
//            @RequestParam("isbn") String isbn
//    ) {
//        Map<String, Object> Book = new HashMap<String, Object>();
//        return null;
////    }
//
//}
