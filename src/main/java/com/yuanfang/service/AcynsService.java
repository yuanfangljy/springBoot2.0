package com.yuanfang.service;

import org.springframework.scheduling.annotation.Async;

public interface AcynsService {

    @Async
    public String indexAcyns();
}
