package com.linzlb.controller;

import com.linzlb.annotation.Limit;
import com.linzlb.dto.ResponseDto;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linzlb
 * @since 2021/5/19
 */
@Api(value="limit Controller", tags={"limit接口"})
@RestController
@RequestMapping("/limit")
public class LimiterController {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    @Limit(key = "test", period = 100, count = 10)
    @ApiOperation(value = "测试分布式限流", notes = "测试分布式限流")
    @GetMapping("/test")
    public ResponseDto testLimiter() {
        // 意味著 100S 内最多允許訪問10次
        return ResponseResultUtil.generateSuccessResult(ATOMIC_INTEGER.incrementAndGet());
    }
}