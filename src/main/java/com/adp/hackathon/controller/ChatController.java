package com.adp.hackathon.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.adp.hackathon.model.Hello;
import com.adp.hackathon.model.User;
 
 
@Controller
public class ChatController {
 
  @MessageMapping("/hello")
  @SendTo("/topic/hi")
  public Hello greeting(User user) throws Exception {
    return new Hello("Hi, " + user.getName() + "!");
  }
}