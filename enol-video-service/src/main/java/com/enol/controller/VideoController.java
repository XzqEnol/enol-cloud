package com.enol.controller;

import com.enol.domain.Video;
import com.enol.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoOrderService videoOrderService;

    @RequestMapping("/getById")
    public Object getVideoById(Integer videoId, HttpServletRequest request){
        Video videoById = videoOrderService.getVideoById(videoId);
        videoById.setServerInfo(request.getServerName()+":"+request.getServerPort());
        return videoById;
    }
}
