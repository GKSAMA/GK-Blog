package edu.sdust.ssmstudy.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class DemoController {

    @ResponseBody
    @RequestMapping(value="/test",produces = "application/json;charset=utf-8")
    public String test(String param){
        return param;
    }

    @ResponseBody
    @RequestMapping(value="/test1",produces = "application/json;charset=utf-8")
    public String test1(){
        DemoResponse response = new DemoResponse();
        response.setAge(20);
        response.setName("张三");
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    class DemoResponse{
        String name;
        int age;

        public DemoResponse(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public DemoResponse() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
