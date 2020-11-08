package com.enol.controller;

import com.enol.domain.Video;
import com.enol.domain.VideoOrder;
import com.enol.service.VideoService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/video/v2")
public class VideoOrderController {
    @Autowired
    private VideoService videoService;

    int temp = 0;

    @RequestMapping("/save")
    public Object findById(int videoId){
/*        List<ServiceInstance> instances = discoveryClient.getInstances("enol-video-service");
        ServiceInstance serviceInstance = instances.get(0);*/
        //Video video = restTemplate.getForObject("http://enol-video-service/video/getById?videoId=" + videoId, Video.class);
        Video video =  videoService.getById(videoId);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setCreateTime(new Date());
        videoOrder.setVideoId(videoId);
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setServerInfo(video.getServerInfo());
        return videoOrder;
    }


    @RequestMapping("/list")
    public Object listOrder(HttpServletRequest request){
        /*try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){

        }
        temp++;
        if (temp%3 == 0){
            throw new RuntimeException();
        }*/
        Map<String, Object> retMap = Maps.newHashMap();
        retMap.put("title1","伊诺尔课程专题");
        retMap.put("title2","alibabaCloud课程专题");
        retMap.put("port",request.getServerPort());
        return retMap;
    }
}
