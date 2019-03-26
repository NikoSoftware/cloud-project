package net.xiaomotou.commonexception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Time: 2018-11-05 16:07
 * @Feature:
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

}
