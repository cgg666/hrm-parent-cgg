package cuiyi.itsource.hrm.controller;

import cuiyi.itsource.hrm.util.AjaxResult;
import cuiyi.itsource.hrm.util.FastDfsApiOpr;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file){

        try {
            //文件名称   asdsdf.sdf.png
            String fileName = file.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            String extName = fileName.substring(index + 1);
            //文件内容
            byte[] bytes = file.getBytes();
            String file_id = FastDfsApiOpr.upload(bytes, extName);
            return AjaxResult.me().setSuccess(true).setMessage("上传成功!").setResultObj(file_id);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("上传失败！"+e.getMessage());
        }
    }
}
