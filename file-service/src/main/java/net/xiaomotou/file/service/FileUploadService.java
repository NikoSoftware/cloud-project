package net.xiaomotou.file.service;

import com.Ostermiller.util.CircularByteBuffer;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.xiaomotou.commonexception.BusinessException;
import net.xiaomotou.commonexception.ExceptionEnum;
import net.xiaomotou.file.config.FtpConfig;
import net.xiaomotou.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<String> getAllFile() {
        ArrayList<String> arrayList = new ArrayList<>();
        File docFile = new File(ftpConfig.getFileUpdatePath());
        if (docFile.exists() && docFile.isDirectory()) {
            ArrayList<File> list = new ArrayList<>();
            for (File file : docFile.listFiles()) {
                list.add(file);
            }
            if (list != null && list.size() > 0) {  //时间顺序排序
                Collections.sort(list, (file, newFile) -> {
                    if (file.lastModified() < newFile.lastModified()) {
                        return -1;
                    } else if (file.lastModified() == newFile.lastModified()) {
                        return 0;
                    } else {
                        return 1;
                    }

                });
            }
            for (File file : list) {
                arrayList.add(file.getName());
            }
        }
        return arrayList;
    }


    public InputStream compressFile(String fileName,double accuracy, long desFileSize, int desMaxWidth,int desMaxHeight) throws Exception {


        File srcFile = new File(ftpConfig.getFileUpdatePath() + fileName);
        //获取图片信息
        BufferedImage bim = ImageIO.read(srcFile);
        int srcWidth = bim.getWidth();
        int srcHeight = bim.getHeight();
        Thumbnails.Builder builder = Thumbnails.of(srcFile);

        // 指定大小（宽或高超出会才会被缩放）
        if(srcWidth > desMaxWidth || srcHeight > desMaxHeight) {
            builder.size(desMaxWidth, desMaxHeight);
        }else{
            //宽高均小，指定原大小
            builder.size(srcWidth,srcHeight);
        }
        // 写入到内存
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
        builder.toOutputStream(baos);

        // 递归压缩，直到目标文件大小小于desFileSize
        byte[] bytes = commpressPicCycle(baos.toByteArray(), desFileSize, accuracy);


        System.out.println("图片长度："+bytes.length);


        CircularByteBuffer cbb = new CircularByteBuffer();
//        new Thread(() -> {
//            try {
//                Thumbnails.of(ftpConfig.getFileUpdatePath() + fileName).scale(0.5f).outputQuality(0.7f).toOutputStream(cbb.getOutputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        ).start();
        return new ByteArrayInputStream(bytes);
    }




    private static byte[] commpressPicCycle(byte[] bytes, long desFileSize, double accuracy) throws IOException {
        // File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = bytes.length;
        // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return bytes;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(new ByteArrayInputStream(bytes));
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        int desWidth = new BigDecimal(srcWdith).multiply(
                new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeigth).multiply(
                new BigDecimal(accuracy)).intValue();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
        Thumbnails.of(new ByteArrayInputStream(bytes)).size(desWidth, desHeight).outputQuality(accuracy).toOutputStream(baos);
        return commpressPicCycle(baos.toByteArray(), desFileSize, accuracy);
    }


}
