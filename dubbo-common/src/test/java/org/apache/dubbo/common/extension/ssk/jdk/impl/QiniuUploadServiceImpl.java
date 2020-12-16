package org.apache.dubbo.common.extension.ssk.jdk.impl;

import org.apache.dubbo.common.extension.ssk.jdk.UploadService;

/**
 * @author ssk
 * @date 2020/12/16
 */
public class QiniuUploadServiceImpl implements UploadService {

    @Override
    public String upload(String url) {
        System.out.println("七牛云图片上传成功......");
        return "qiniu://" + url;
    }
}
