package com.pnshsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private InnerService innerService;

    @Override
    public String hello(String name) {
        String returnStr = "world";

        if ("qinyuan".equals(name))
            returnStr = "cool";
        if ("pnshsh".equals(name))
            returnStr = "handsome";

        if (innerService.isLove(name)) {
            returnStr += " my love";
        }

        return returnStr;
    }
}
