package net.xiaomotou.file.service;

import lombok.extern.slf4j.Slf4j;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
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

        String fileName = randomCode(4) + System.currentTimeMillis() + suffixName;
        File dest = new File(filePath, fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        multipartFile.transferTo(dest);
        log.info("[图片上传成功]:{}",dest.getAbsolutePath());
        return fileName;
    }


    /**
     * 随机生成码
     *
     * @param length 生成随机码长度
     * @return 生成随机码
     */
    public static String randomCode(int length) {
        // 最终生成的密码
        String code = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 随机生成0或1，用来确定是当前使用数字还是字母 (0则输出数字，1则输出字母)
            int charOrNum = random.nextInt(2);
            if (charOrNum == 1) {
                // 随机生成0或1，用来判断是大写字母还是小写字母 (0则输出小写字母，1则输出大写字母)
                int temp = random.nextInt(2) == 1 ? 65 : 97;
                code += (char) (random.nextInt(26) + temp);
            } else {
                // 生成随机数字
                code += random.nextInt(10);
            }
        }
        return code;
    }


}
