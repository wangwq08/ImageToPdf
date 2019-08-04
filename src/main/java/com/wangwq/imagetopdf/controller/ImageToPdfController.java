package com.wangwq.imagetopdf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Description: get multiple images
 * @Author: wangwq
 * @CreateDate: 2019/08/04 22:16
 */
@Component
@RestController
@RequestMapping(value = "api/")
public class ImageToPdfController {

    String url = "";
    String path = "";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description: use interface to get iamge
     * @Author: wangwq
     * @CreateDate: 2019/08/04 22:20
     */
    @GetMapping(value = "getiamge")
    public String getImage() throws IOException {
        return "loading success";
    }
}
