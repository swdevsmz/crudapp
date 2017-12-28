package com.crudapp.controller;

import java.util.List;

import com.crudapp.form.IndexForm;
import com.crudapp.repository.UserRepository;
import com.crudapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


/*@RestController*/
@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    /*@ResponseBody*/
    public String index(Model model) {


        model.addAttribute("message", "やったー!!");
        model.addAttribute("indexForm", new IndexForm());
        return "index";
/*
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
  */
    }

    @RequestMapping(value="/result", method=RequestMethod.POST)
    public String indexFormSubmit(@ModelAttribute IndexForm indexForm, Model model) {
        if (indexForm.getId() == 1) {
            indexForm.setContent("お前がナンバーワンだ！");
        }
        model.addAttribute("indexForm", indexForm);
        return "result";
    }

    @RequestMapping("/select")
    public List<User> select(@RequestParam("id") Integer id) {
        System.out.println("aaa");
        List<User> list = userRepository.findById(id);
        return list;
    }
}
