//package com.softusing.hejunjie.web;
//
//import com.softusing.hejunjie.entity.Book;
//import com.softusing.hejunjie.server.BookServer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/api/v1")
//public class BookApp {
//
//    @Autowired
//    private BookServer bookServer;
//
//
//    /*
//    获取读书清单列表
//     */
//    @GetMapping("/books")
//    public List<Book> getAll() {
//        return bookServer.findAll();
//    }
//
//    @PostMapping("/addBooks")
//    public int post(@RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status) {
//
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
//        return bookServer.insert(book);
//    }
//
//    @GetMapping("/books/{id}")
//    public Book getOne(@PathVariable long id) {
//        return bookServer.findById(id);
//    }
//
////
////    @PutMapping("/books")
////    public Book update(
////            @RequestParam long id,
////            @RequestParam String name,
////            @RequestParam String author,
////            @RequestParam String description,
////            @RequestParam int status
////    ) {
////        Book book = new Book();
////        book.setId(id);
////        book.setName(name);
////        book.setAuthor(author);
////        book.setDescription(description);
////        book.setStatus(status);
////        return bookServer.save(book);
////
////    }
////
////    /*
////    删除一个书单信息
////     */
//    @DeleteMapping("/books/{id}")
//    public void deleteOne(@PathVariable int id) {
//        bookServer.deleteById(id);
//    }
////
////    @PostMapping("/books/by")
////    public List<Book> findBy(@RequestParam String description) {
////        return bookServer.findByDescriptionEndsWith(description);
////    }
////
////
////    public List<Book> findBy(@RequestParam int len) {
////        return bookServer.findByJPQL(len);
////    }
//
//}

