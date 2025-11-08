package com.keith.copy;

import java.io.Serializable;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/11/12 0012 16:56
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L; // 推荐添加序列化ID
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
