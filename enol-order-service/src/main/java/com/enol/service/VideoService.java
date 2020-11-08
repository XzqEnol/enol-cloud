package com.enol.service;

import com.enol.domain.Video;
import com.enol.service.fallback.VideoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//fallback指定容错实现类，方法报错后执行容错类对应方法
@FeignClient(value = "enol-video-service", fallback = VideoServiceFallBack.class)
public interface VideoService {

    @RequestMapping("/video/getById")
    Video getById(@RequestParam("videoId")int videoId);
}
