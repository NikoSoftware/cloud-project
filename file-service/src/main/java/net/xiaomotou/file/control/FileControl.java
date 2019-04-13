package net.xiaomotou.file.control;


import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.file.config.FtpConfig;
import net.xiaomotou.file.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileControl {


    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    FtpConfig ftpConfig;

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

    @GetMapping("/downloadFile")
    public ResponseEntity<InputStreamResource> downloadFile(String fileName){

        InputStream inputStream =null;
        File file = new File(ftpConfig.getFileUpdatePath()+fileName);
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
          throw new BusinessException(ExceptionEnum.IMAGE_PARAM_FAILED);
        }
//        InputStream inputStream =null;
//
//        try {
//            inputStream = fileUploadService.compressFile(fileName,0.7,1024*1024,1080,1920);
//        } catch (Exception e) {
//            throw new BusinessException(ExceptionEnum.IMAGE_PARAM_FAILED);
//        }
        log.info("[图片下载]: {}",fileName);
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("content-disposition", "attachment;filename=" + fileName)
                .cacheControl(CacheControl.maxAge(300000, TimeUnit.DAYS).cachePublic())
                .allow(HttpMethod.GET, HttpMethod.OPTIONS)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(inputStream));
    }


    @GetMapping("/getAllFile")
    public ResponseEntity<List<String>> getAllFile(){

        List<String> arrayList = fileUploadService.getAllFile();

       return ResponseEntity.ok(arrayList);
    }


}
