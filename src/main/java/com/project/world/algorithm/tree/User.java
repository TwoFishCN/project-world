package com.project.world.algorithm.tree;

public class User {

    public Long id;
    public String name;
    public String password;
    public String other;

    public boolean idGreaterThan(User user){
        return this.id - user.id > 0;
    }
}
