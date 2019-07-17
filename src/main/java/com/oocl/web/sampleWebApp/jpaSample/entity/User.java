package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

@Entity
public class User {

    public User(String name){
        this.name=name;

    }
    public User(){}
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name="name",length=64)
  private String name;



    public void setName(String name) {
    this.name = name;
  }

    public Long getId() {
        return id;
    }

    public String getName() {
    return name;
  }
}
