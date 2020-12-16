package org.apache.dubbo.common.extension.ssk.jdk.impl;

import org.apache.dubbo.common.extension.ssk.jdk.UploadService;

/**
 * @author ssk
 * @date 2020/12/16
 */
public class AliyunUploadServiceImpl implements UploadService {

    @Override
    public String upload(String url) {
        System.out.println("阿里云图片上传成功......");
        return "aliyun://" + url;
    }
}
