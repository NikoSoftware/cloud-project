package net.xiaomotou.file.service;

import lombok.extern.slf4j.Slf4j;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Slf4j
@Service
public class FileUploadService {

    @Value("${fileUpdatePath}")
    String filePath;


    public String updateFile(MultipartFile multipartFile) throws IOException {

        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new BusinessException(ExceptionEnum.IMAGE_PARAM_FAILED);
        }

        String oldFileName = multipartFile.getOriginalFilename();

        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));

        String fileName = NumberUtils.randomCode(4) + System.currentTimeMillis() + suffixName;
        File dest = new File(filePath, fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        multipartFile.transferTo(dest);
        log.info("[图片上传成功]:{}",dest.getAbsolutePath());
        return fileName;
    }




}
