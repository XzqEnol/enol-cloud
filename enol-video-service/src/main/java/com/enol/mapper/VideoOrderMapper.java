package com.enol.mapper;

import com.enol.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface VideoOrderMapper {

    @Select("select * from video where id = #{videoId}")
    Video getVideoById(@Param("videoId") Integer videoId);
}
