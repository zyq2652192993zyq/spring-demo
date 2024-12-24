package com.ebay.ace.demo.entiry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ebay.ace.demo.handler.ParamListTypeHandler;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "node_table", autoResultMap = true)
public class Node {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;

    @TableField(typeHandler = ParamListTypeHandler.class)
    private List<Param> parameters;
}