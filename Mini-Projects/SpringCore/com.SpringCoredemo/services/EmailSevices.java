package com.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component //Marks this as a springBean
public class EmailService implements MessageService{
  public void sendMessage(String message){
     System.out.println("Sending Email: " +message);
  }
}
