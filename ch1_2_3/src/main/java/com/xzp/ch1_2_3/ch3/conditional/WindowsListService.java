package com.xzp.ch1_2_3.ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
