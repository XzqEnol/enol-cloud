package com.enol.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 捕捉setinel异常
 */
@Component
public class EnolBlockHanlder implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        Map<String, Object> backMap = Maps.newHashMap();
            if(e instanceof FlowException){
                backMap.put("code",-1);
                backMap.put("msg","限流异常");
            } else if (e instanceof DegradeException){
                backMap.put("code",-2);
                backMap.put("msg","降级异常");
            } else if (e instanceof ParamFlowException){
                backMap.put("code",-3);
                backMap.put("msg","热点-异常啦");
            }else if (e instanceof SystemBlockException){
                backMap.put("code",-4);
                backMap.put("msg","系统规则-异常啦");
            }else if (e instanceof AuthorityException){
                backMap.put("code",-5);
                backMap.put("msg","认证-异常啦");
            }
        httpServletResponse.setStatus(200);
        httpServletResponse.setHeader("content-type","application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(backMap));
    }
}
