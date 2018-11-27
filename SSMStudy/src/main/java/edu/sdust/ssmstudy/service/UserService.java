package edu.sdust.ssmstudy.service;

import edu.sdust.ssmstudy.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> listAll();
    public boolean auth(String username,String password);
    public  void  adduser(String username,String password,String sex,String email);
    public void login(String username,String password);
}
