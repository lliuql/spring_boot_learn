package com.liu.learn.spring_boot_learn.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: Lqh
 * @time: 2019/7/24 16:59
 */
@Data
public class LoginForm {

    @NotBlank(message = "用户名不能为空")
    @Email
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, message = "密码长度至少6位")
    private String password;
}
