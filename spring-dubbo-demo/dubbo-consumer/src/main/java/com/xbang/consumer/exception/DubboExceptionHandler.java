package com.xbang.consumer.exception;

import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
@RestController
@Slf4j
public class DubboExceptionHandler {
    @ExceptionHandler({InterruptedException.class, ExecutionException.class})
    public Result exception(Exception e){
        log.error(e.getMessage(),e);
        return BaseResult.getResult(ResultEnum.RESULT_FAIL, "");
    }

}
