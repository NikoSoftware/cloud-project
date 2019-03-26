package net.xiaomotou.file.control;


import lombok.extern.slf4j.Slf4j;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.file.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileControl {


    @Autowired
    FileUploadService fileUploadService;

    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    public ResponseEntity<String> updateFile(@RequestParam("file") MultipartFile multipartFile){
        String fileName =null;
        try {
            fileName = fileUploadService.updateFile(multipartFile);
        } catch (IOException e) {
            log.error("[图片上传失败]",e);
            throw new BusinessException(ExceptionEnum.IMAGE_STORAGE_FAILED);
        }
        return ResponseEntity.ok(fileName);
    }




}
