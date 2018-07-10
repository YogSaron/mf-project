package com.company.project.cache;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Logan on 2018/7/10.
 */
@Component
public class TaskCache {

    @Scheduled(fixedRate = 60000*30)
    public void removeLoginCache() {

        UserLoginCache.remove();

    }
}
