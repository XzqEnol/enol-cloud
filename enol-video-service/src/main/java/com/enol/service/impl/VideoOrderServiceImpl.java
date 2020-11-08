package com.enol.service.impl;

import com.enol.mapper.VideoOrderMapper;
import com.enol.domain.Video;
import com.enol.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Override
    public Video getVideoById(Integer id) {
        return videoOrderMapper.getVideoById(id);
    }
}
