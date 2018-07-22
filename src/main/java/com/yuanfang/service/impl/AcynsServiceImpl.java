package com.yuanfang.service.impl;

import com.yuanfang.service.AcynsService;
import org.springframework.stereotype.Service;

@Service
public class AcynsServiceImpl implements AcynsService{



    public String indexAcyns() {
        System.out.println("==============="+3);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("==============="+4);
        return "yuanfang";
    }
}
