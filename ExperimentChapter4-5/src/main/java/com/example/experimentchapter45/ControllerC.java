package com.example.experimentchapter45;

import com.example.experimentchapter45.Mapper.GoodMapper;
import com.example.experimentchapter45.Mapper.UserMapper;
import com.example.experimentchapter45.Model.Good;
import com.example.experimentchapter45.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/good")
public class ControllerC
{
    @Autowired
    GoodMapper goodMapper;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/login")
    public String logIn()
    {
        return "LogIn";
    }

    @GetMapping("/signup")
    public String signUp()
    {
        return "SignUp";
    }

    @PostMapping ("/checkuser")
    public String checkUser(@ModelAttribute("form")User user, Model model)
    {
        List<User> users= userMapper.findAllUsers();
        for (User u : users)
        {
            if(u.getPassword().equals(user.getPassword())&&u.getUsername().equals(user.getUsername()))
            {
                List<Good> goods=goodMapper.findAllGoods();
                model.addAttribute("goods",goods);
                return "redirect:/good/list";
            }
        }
        return "LogIn";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("form")User newUser)
    {
        List<User> users= userMapper.findAllUsers();
        for (User u : users)
        {
            if(u.getPassword().equals(newUser.getPassword())&&u.getUsername().equals(newUser.getUsername()))
                return "redirect:/good/list";
        }
        userMapper.insertUser(newUser);
        return "redirect:/good/login";
    }

    @GetMapping ("/signout")
    public String signout()
    {
        return "SignOut";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("form")User deleteUser)
    {
        userMapper.deleteUser(deleteUser);
        return "redirect:/good/login";
    }

    @GetMapping("/updateuser")
    public String updateUser()
    {
        return "UpdateUser";
    }

    @PostMapping("/update")
    public String checkupdate(@ModelAttribute("form")User user)
    {
        List<User> users= userMapper.findAllUsers();
        for (User u : users)
        {
            if(u.getUsername().equals(user.getUsername()))
                userMapper.updateUser(user);
        }
        return "redirect:/good/login";
    }

    /**
    上面的是用户数据相关内容，下面是货物数据相关内容
     */

    @GetMapping("/list")
    public String goodList(Model model)
    {
        List<Good> goods=goodMapper.findAllGoods();
        model.addAttribute("goods",goods);
        return "Goods";
    }

    @GetMapping("/updategood")
    public String goodUpdate()
    {
        return "UpdateGood";
    }

    @PostMapping("/tryupdate")
    public String TryUpdateGood(@ModelAttribute("form")Good good)
    {
        goodMapper.updateById(good.getPrice(),good.getStock(),good.getId());
        return "redirect:/good/list";
    }

    @GetMapping("/deletegood")
    public String goodDelete()
    {
        return "DeleteGoods";
    }

    @PostMapping("/trydelete")
    public String TryDeleteGood(@ModelAttribute("id1")Object id1,@ModelAttribute("id2")Object id2)
    {
        goodMapper.BatchDelete(id1,id2);
        return "redirect:/good/list";
    }

    @GetMapping("/addgood")
    public String goodAdd()
    {
        return "AddGood";
    }

    @PostMapping("/tryaddgood")
    public String TryAddGood(@ModelAttribute("form")Good newGood)
    {
        goodMapper.insertGood(newGood);
        return "redirect:/good/list";
    }
}
