package com.pnshsh.service;

import org.springframework.stereotype.Service;

@Service
public class InnerServiceImpl implements InnerService {
    @Override
    public boolean isLove(String name) {
        if ("pnshsh".equals(name)) {
            return true;
        }
        return false;
    }

    @Override
    public String whoAreU() {
        return "James";
    }
}
