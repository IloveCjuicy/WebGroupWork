package com.example.experimentchapter45.Model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User
{
    @TableId(value = "id")
    private Object id;
    private Object username;
    private Object password;
}

