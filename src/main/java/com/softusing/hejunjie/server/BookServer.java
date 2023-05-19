package com.softusing.hejunjie.server;

import com.softusing.hejunjie.entity.Book;
import com.softusing.hejunjie.entity.BookExample;
import com.softusing.hejunjie.entity.MyPage;
import com.softusing.hejunjie.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServer implements BookInterface {

    @Autowired
    private BookMapper bookMapper;


    /*
    新增一个书单信息
     */
    public int save(Book book) {
        return bookMapper.insert(book);
    }

    //删除
    public void delete(long id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    /*
    更新一个书单
     */
    public int update(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public Book deleteOne(long id) {
        return null;
    }

    @Override
    public Book findOne(long id) {
        return null;
    }

    /*
     查看一条
     */
    public Book fidOne(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /*
    通过id查询
     */
    public Book findById(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    /*
    通过id来删除
     */
    //void 删除 无返回值 所以用void
    public void deleteById(long id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    public List<Book> findAll() {
        return bookMapper.selectByExample(new BookExample());
    }


    @Override
    public List<Book> queryBooksByArray(int currPage, int pageSize, MyPage myPage) {
        //查询全部数据
        List<Book> bookList = bookMapper.queryBooksByArray();

        myPage.setTotalPage((int) Math.ceil(bookList.size() * 1.0 / pageSize));
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        int lastIndex;
        //到第几条数据结束
        if (currPage < myPage.getTotalPage()) {
             lastIndex = currPage*pageSize;
        }else {
            lastIndex = bookList.size();
        }
        return bookList.subList(firstIndex, lastIndex); //直接在list中截取

    }
}


