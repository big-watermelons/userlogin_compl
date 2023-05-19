package com.softusing.hejunjie.controller;

import com.softusing.hejunjie.entity.Book;
import com.softusing.hejunjie.entity.MyPage;
import com.softusing.hejunjie.exception.BookNotFoundException;
import com.softusing.hejunjie.server.BookInterface;
import com.softusing.hejunjie.server.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookServer bookServer;

    /**
     * 获取整个书名列表
     *
     * @param model
     * @return
     */
    @GetMapping("/books-list")
    public String list(Model model) {
        List<Book> bookList = bookServer.findAll();
        model.addAttribute("bookList", bookList);
        return "books";
    }


    /**
     * 通过id来查找书名
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookServer.findById(id);
        if (book == null) {
          throw new BookNotFoundException("书单信息不存在");
        }
        model.addAttribute("book", book);
        return "book";
    }


    /**
     * 跳转input提交页面
     *
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    /**
     * 跳转到更新页面input
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookServer.findById(id);
        model.addAttribute("book", book);
        return "input";

    }

    /**
     * 提交一个书单信息
     *
     * @param book
     * @return
     */


    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        if (book.getId() == null) {
            bookServer.save(book);
            attributes.addFlashAttribute("message", "<" + book.getName() + ">信息提交成功");
        } else {
            bookServer.update(book);
            attributes.addFlashAttribute("message", "<" + book.getName() + ">信息提交成功");
        }
//        Book book = bookServer.insert(book);
//        if (book1 != null) {
//            attributes.addFlashAttribute("message", "<" + book1.getName() + ">信息提交成功");
//        }
        return "redirect:books";
    }

    @GetMapping("/books")
    public String getBookByArray(@RequestParam(defaultValue = "1") int currPage, @RequestParam (defaultValue = "5") int pageSize ,Model model,MyPage myPage) {
        List<Book> bookList = bookServer.queryBooksByArray(currPage, pageSize, myPage);
        model.addAttribute("bookList",bookList);
        myPage.setThisPage(currPage);
        myPage.setPageSize(pageSize);
        model.addAttribute("page",myPage);
        return "books";
    }

}