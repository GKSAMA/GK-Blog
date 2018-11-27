package edu.sdust.ssmstudy.service;
import edu.sdust.ssmstudy.pojo.Basebookinfo;

import java.util.List;

public interface BookService {
    public List<Basebookinfo> selectbookbyname(String bname);

}
