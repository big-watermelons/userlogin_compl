package com.softusing.hejunjie.server;

import java.util.List;

import com.softusing.hejunjie.entity.Book;
import com.softusing.hejunjie.entity.MyPage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookInterface {

    //创建书单
    int save(Book book);

    //更新书单
    int update(Book book);

    //删除书单
    Book deleteOne(long id);

    //根据id查询
    Book findOne(long id);

    //查询所有用户
    List<Book> findAll();

    //接口

    List<Book> queryBooksByArray(int currPage, int pageSize, MyPage myPage);
}
