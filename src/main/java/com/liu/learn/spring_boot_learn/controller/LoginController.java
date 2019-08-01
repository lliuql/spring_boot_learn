package com.liu.learn.spring_boot_learn.controller;

import com.liu.learn.spring_boot_learn.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Lqh
 * @time: 2019/7/24 17:02
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private ObjectError objectError;

    @GetMapping("index.html")
    public String index() {
        return "login";
    }

    @PostMapping("/user")
    public String login (@Valid LoginForm loginForm, BindingResult bindingResult) {
        ArrayList<String> errorStr = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {

                errorStr.add(error.getDefaultMessage());
            }
        }
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        ObjectError error = allErrors.get(0);
        String objectName = error.getObjectName();
        Object[] arguments = error.getArguments();
        String code = error.getCode();
        String[] codes = error.getCodes();
        String defaultMessage = error.getDefaultMessage();
        return "success";
    }


}
