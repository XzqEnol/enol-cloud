package com.enol.service.fallback;

import com.enol.domain.Video;
import com.enol.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceFallBack implements VideoService {
    @Override
    public Video getById(int videoId) {
        Video video = new Video();
        video.setTitle("这是fallback兜底数据");
        video.setPrice(100);
        return video;
    }
}
