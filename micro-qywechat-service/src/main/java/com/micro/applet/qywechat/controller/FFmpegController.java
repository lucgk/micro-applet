package com.micro.applet.qywechat.controller;

import cn.hutool.core.io.FileUtil;
import com.micro.applet.qywechat.response.AccessToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ffmpeg
 *
 * @author liuhui
 * @version 1.0, 2021/6/19 23:18
 */
@Api(value = "/api/ffmpeg",tags = {"FFmpegController"})
@RestController
@RequestMapping("/ffmpeg")
@Slf4j
public class FFmpegController {


    @Autowired
     private RestTemplate  restTemplate;

    @Value("${ffmpeg.path}")
    private String pPath;


    @RequestMapping(value = "/parsing",method = RequestMethod.POST)
    @ApiOperation(value = "parsing ... ",notes = "parsing",response = String.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "source",value = "来源",defaultValue = "",required = true),
        @ApiImplicitParam(name = "name",value = "name",defaultValue = "",required = true)

    })
    public String parsing(@RequestParam(value = "source", required = true)String source,@RequestParam(value = "name", required = true)String name) throws IOException {
        // long l = System.currentTimeMillis();
        long l = 1624122323097L;
        // downFile(source,l);
        // copyFile(name,l);
        ffmpegFile(name,l);
        return "SUCCESS";
    }

    private void copyFile(String name, long l) throws IOException {
        String outPathPre = pPath+File.separator+l+File.separator;
        String outPath = pPath+File.separator+"out";
        File dir = FileUtil.mkdir(outPath);
        String command = "cmd /C  copy /b  "+outPathPre+"*.ts  "+dir+File.separator+name+".ts";
        Process exec = Runtime.getRuntime().exec(command);
    }

    private void ffmpegFile(String name, long l) throws IOException {
        String prePath = pPath+File.separator+l+File.separator;
        String outPathPre = pPath+File.separator+l+File.separator;
        String outPath = pPath+File.separator+"out";
        File dir = FileUtil.mkdir(outPath);
        String command = "cmd ffmpeg -f concat  -i "+prePath+"recoder.txt -c copy "+dir+File.separator+name+".mp4";
        Process exec = Runtime.getRuntime().exec(command);

    }

    private void downFile(String source, long l) throws IOException {
        String rs = restTemplate.getForObject(source, String.class);
        String prePath = pPath+File.separator+l+File.separator;
        FileUtil.mkdir(prePath);
        File rFile = new File(prePath+"recoder.txt");
        BufferedReader  br = new BufferedReader(new InputStreamReader(new StringBufferInputStream(rs)));
        PrintWriter  pw = new PrintWriter(rFile);
        String line = br.readLine();

        while (null!=line){
            if(line.startsWith("#")){
                line = br.readLine();
                continue;
            }else {
                File  tmp = new File(prePath+line.substring(line.lastIndexOf("/"),line.length()));
                log.info("tmp : "+tmp.getAbsolutePath());
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.valueOf("video/MP2T"));
                headers.add("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36");
                ResponseEntity<byte[]> response = restTemplate
                    .exchange(line, HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);
                File file = FileUtil.writeBytes(response.getBody(),tmp);
                pw.println(line);
                line = br.readLine();
            }
        }
    }

}
