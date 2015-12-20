package com.example.copycontacts.domain.entities;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class Calls {
//    @Override
//    public String toString() {
//        return
//                "Name= " + name + '\n' + '\n'
//                ;
//    }

    private long id;
    private String name;

    public Calls() {
    }

    public Calls(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



