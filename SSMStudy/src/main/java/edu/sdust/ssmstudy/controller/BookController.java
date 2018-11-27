package edu.sdust.ssmstudy.controller;


import edu.sdust.ssmstudy.pojo.Basebookinfo;
import edu.sdust.ssmstudy.service.BookService;
import edu.sdust.ssmstudy.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/selectbookbyname")
    public JsonBean selectbookbyname(String bname){
        JsonBean jsonBean = new JsonBean();
        List<Basebookinfo> bookList = null;
        try {
            bookList = bookService.selectbookbyname(bname);
            jsonBean.setCode(1);
            jsonBean.setMsg(bookList);
        }catch (Exception e){
            e.printStackTrace();
            jsonBean.setCode(0);
            jsonBean.setMsg(e.getMessage());
        }finally {
            return jsonBean;
        }
    }


}
