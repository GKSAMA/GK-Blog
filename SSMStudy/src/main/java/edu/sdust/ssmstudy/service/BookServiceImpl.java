package edu.sdust.ssmstudy.service;
import edu.sdust.ssmstudy.mapper.BasebookinfoMapper;
import edu.sdust.ssmstudy.pojo.Basebookinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BasebookinfoMapper basebookinfoMapper;

    @Override
    public List<Basebookinfo> selectbookbyname(String bname){
        List<Basebookinfo> bookList=null;
        try {
            Example example = new Example(Basebookinfo.class);
            example.createCriteria()
                    .andLike("bname",bname);

            bookList = basebookinfoMapper.selectByExample(example);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            return bookList;
        }
    }
}
