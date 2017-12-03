package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    @JsonView(UserSimpleView.class)
    private String id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "自定义注解测试")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank
    private String password;

    @JsonView(UserSimpleView.class)
    @Past(message = "生日必须为过去的时间")
    private Date birthday;
}
