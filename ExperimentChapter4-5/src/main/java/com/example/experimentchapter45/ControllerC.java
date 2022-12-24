package com.example.experimentchapter45;

import com.example.experimentchapter45.Mapper.GoodMapper;
import com.example.experimentchapter45.Mapper.UserMapper;
import com.example.experimentchapter45.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String checkUser(@ModelAttribute("form")User user)
    {
        List<User> users= userMapper.findAllUsers();
        for (User u : users)
        {
            if(u.getPassword().equals(user.getPassword())&&u.getUsername().equals(user.getUsername()))
                return "Goods";
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
                return "Goods";
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


}
