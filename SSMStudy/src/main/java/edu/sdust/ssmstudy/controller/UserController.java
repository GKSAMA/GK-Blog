package edu.sdust.ssmstudy.controller;


import com.google.gson.Gson;
import edu.sdust.ssmstudy.pojo.User;
import edu.sdust.ssmstudy.service.UserService;
import edu.sdust.ssmstudy.vo.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/flogin" ,produces = "application/json;charset=utf-8")
    public String login(@RequestBody User user){


        LoginResult loginResult = new LoginResult();

        boolean result = userService.auth(user.getUsername(),user.getPassword());

        if (result){
            loginResult.setMsg("success");
            loginResult.setResult(0);
        }else {
            loginResult.setMsg("error");
            loginResult.setResult(-1);
        }

        return new Gson().toJson(loginResult);
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public String test(){
        return "{}";
    }



    class LoginResult {
        private int result;
        private String msg;



        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public JsonBean Login(String username, String password){
        JsonBean jsonBean = new JsonBean();

        try {
            userService.login(username,password);
            jsonBean.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonBean.setCode(0);
            jsonBean.setMsg(e.getMessage());
        }
//        if(username.equals("a")&&password.equals("b")){
//            jsonBean.setCode(1);
//
//        }else{
//            jsonBean.setCode(0);
//            jsonBean.setMsg("用户名或密码错误");
//        }
        return jsonBean;
    }


    @ResponseBody
    @RequestMapping(value = "/listall" ,produces = "application/json;charset=utf-8")
    public String listAll(){
        Gson gson = new Gson();
        return gson.toJson(userService.listAll());
    }

    @ResponseBody
    @RequestMapping(value = "/adduser",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public  void Adduser(@RequestBody User user ){
        Gson gson = new Gson();
        try {
            userService.adduser(user.getUsername(),user.getPassword(),user.getSex(),user.getEmail());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
