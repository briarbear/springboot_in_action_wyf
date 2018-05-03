package com.xzp.ch1_2_3.ch3.conditional;

import org.springframework.stereotype.Service;

@Service
public class LinuxListService implements ListService{

    @Override
    public String showListCmd() {
        return "ls";
    }

}
