package com.springcoredemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.springcoredemo.config.AppConfig;
import com.springcoredemo.service.MessageService;

Public class MainApp{
  public static void main(String[] args){
     ApplicationContext context = new AnnotationConfig ApplicationContext(App.class);
     MessageService messageServices = context.getBean(MessageServices.class);
     messageServices.sendMessage("Hello from Spring Core!");
  }
}

