package net.xiaomotou.file.service;

import lombok.extern.slf4j.Slf4j;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.file.config.FtpConfig;
import net.xiaomotou.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class FileUploadService {

    @Autowired
    FtpConfig ftpConfig;

//    @Autowired
//    FTPClient ftpClient;

    public String updateFile(MultipartFile multipartFile) throws IOException {

        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new BusinessException(ExceptionEnum.IMAGE_PARAM_FAILED);
        }

        String oldFileName = multipartFile.getOriginalFilename();

        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));

        String fileName = NumberUtils.generateCode(4) + System.currentTimeMillis() + suffixName;
        File dest = new File(ftpConfig.getFileUpdatePath(), fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        multipartFile.transferTo(dest);
        log.info("[图片上传成功]:{}", dest.getAbsolutePath());
        return fileName;
    }


    public InputStream downloadFile(String fileName) throws Exception {
//        InputStream inputStream = null;
//        ftpClient.changeWorkingDirectory(ftpConfig.getFileUpdatePath());
//        FTPFile[] files=ftpClient.listFiles();
//        System.out.println(files);
//        FileOutputStream fos = new FileOutputStream(new File("C:/usr/imageDoc/"+fileName));
//       // inputStream = ftpClient.retrieveFileStream(fileName);
//         ftpClient.retrieveFile(fileName, fos);
//        fos.close();



        return null;
    }


}
