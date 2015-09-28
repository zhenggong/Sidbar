package com.example.sidbar;

/**
 * Created by zheng.gong on 15-9-17.
 */
public class People {
    private String id;
    private String name;
    private String avatar_url;

    public People(){

    }

    public People(String id,String name, String avatar_url){
        this.id = id;
        this.name = name;
        this.avatar_url = avatar_url;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAvatar(){
        return this.avatar_url;
    }
}
