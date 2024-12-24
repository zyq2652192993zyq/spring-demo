package com.ebay.ace.demo.entiry;

import lombok.Data;

@Data
public class Param {
    private String desc;
    private Long id;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
