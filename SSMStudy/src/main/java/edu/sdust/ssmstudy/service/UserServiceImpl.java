package edu.sdust.ssmstudy.service;

import edu.sdust.ssmstudy.mapper.UserMapper;
import edu.sdust.ssmstudy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> listAll() {
        List<User> users = userMapper.selectAll();

        return  users;
    }

    @Override
    public boolean auth(String username, String password) {
        Example example = new Example(User.class);
        //andEqualTo内参数分别是数据库中的字段名，后面是参数
        example.createCriteria()
                .andEqualTo("username",username);

        List<User> users = userMapper.selectByExample(example);

        if(users.size()==0)
            return false;
        User user= users.get(0);
        if(user.getPassword().equals(password))
            return true;
        return false;
    }

    @Override
    public void adduser(String username, String password, String sex, String email) {
        Example example = new Example(User.class);
        User user = new User();
        if(username.equals(null)){
            throw new RuntimeException("用户名不存在");
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setEmail(email);

        try {
            userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void login(String username, String password){
        if (username==null || username.isEmpty()){
            throw new RuntimeException("用户名空！");
        }
        if (password==null || password.isEmpty()){
            throw new RuntimeException("请输入密码！");
        }

        User u=new User();
        u.setUsername(username);
        u.setPassword(password);

        User user=null;

        try {
            user = userMapper.selectOne(u);
            if (user==null){
                throw new RuntimeException("用户信息错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
