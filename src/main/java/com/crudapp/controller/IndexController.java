package com.crudapp.controller;

import com.crudapp.repository.UserRepository;
import com.crudapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@RestController
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        StringBuilder sb = new StringBuilder();

        System.out.println("[START] データベースに接続してデータを取得します。");
        Page<User> users = userRepository.findAll(new PageRequest(0, 10));
        for (User user : users) {
            System.out.println(user.getName() + " = " + user.getId());
            sb.append(user.getName() + " = " + user.getId());
        }
        System.out.println("[END  ] データベースに接続してデータを取得します。");

        //return "Hello world";
        return sb.toString();
    }
}
