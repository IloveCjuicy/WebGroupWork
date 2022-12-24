package com.example.experimentchapter45.Model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Good
{
    @TableId(value = "id")
    private Object id;
    private Object goodname;
    private Object price;
    private Object stock;
}