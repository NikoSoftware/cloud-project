package net.xiaomotou.commonexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleException(BusinessException e){
        ExceptionEnum em = e.getExceptionEnum();
        log.error("[错误码：]"+em.getCode()+" 错误："+em.getMsg());
        return ResponseEntity.status(em.getCode()).body(em.getMsg());
    }

}
