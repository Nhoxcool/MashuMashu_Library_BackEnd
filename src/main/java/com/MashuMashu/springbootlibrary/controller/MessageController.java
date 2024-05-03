package com.MashuMashu.springbootlibrary.controller;

import com.MashuMashu.springbootlibrary.Service.MessageService;
import com.MashuMashu.springbootlibrary.entity.Message;
import com.MashuMashu.springbootlibrary.requestmodels.AdminQuestionRequest;
import com.MashuMashu.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token, @RequestBody Message messageRequest) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messageService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token, @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
       if(admin == null || !admin.equals("admin")) {
           throw new Exception("Administration page only.");
       }
       messageService.putMessage(adminQuestionRequest, userEmail);
    }
}
