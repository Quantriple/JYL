package com.Qqq.controller;

import com.Qqq.entity.TUser;
import com.Qqq.mapper.TUserMapper;
import com.Qqq.util.GetSqlSession;
import com.Qqq.util.ReadExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2019/1/3.
 */
@RestController
public class WordCal {
    private Logger logger = LoggerFactory.getLogger(WordCal.class);
    @Autowired
    @Qualifier(value="SqlSessionFactory")
    private  SqlSessionFactory sqlSessionFactory;


    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.error("this is log error");
        logger.warn("this is log warn");
        logger.info("this is log info");
        logger.debug("this is log debug");
        logger.trace("this is log trace");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        final MultipartFile file = multipartRequest.getFile("file");
        String fileName = file.getOriginalFilename();


        //String filePath=file.;
        /*String rootDir = request.getRealPath("/");
        String relatDir = File.separator+"resources"+File.separator+"bussiness"
                +File.separator+"uploadPath"+File.separator+"houseKeeping_imgs";*/

        //文件夹不存在则创建
      /*  File fdir = new File("d://static");
        if (!fdir.exists()) { fdir.mkdirs(); }

        String oriName = file.getOriginalFilename();
        String newName = new Date().getTime()+"_"+oriName;*/
        String pathName = "e://" + System.currentTimeMillis() + "xls";
        File tempFile = new File(pathName);
        file.transferTo(tempFile);
        //这里多了两步操作 先保存 再读取了 后期优化的时候 用这个CommonsMultipartFile直接转化File对象 先完成任务再说
        ReadExcel.readExcel2(new File(pathName));
       /* Map<String, String> result = new HashMap<>();
        result.put("oriName", oriName);
        result.put("realName", tempFile.getName());
        result.put("relatPath", relatDir+File.separator+newName);
        System.out.println("进入方法--------");*/
        //插入数据库
        //  logger.debug("c测试");
        System.out.println("完成");
        return "{200:success}";

    }

    @RequestMapping("test5")
    public String test5() {

        return "{姓名:qqq}";
    }

    @RequestMapping("test3")
    public String test3() {
        System.out.println(sqlSessionFactory);
        TUserMapper mapper = sqlSessionFactory.openSession().getMapper(TUserMapper.class);
        List<TUser> tUsers = mapper.selectAll();
        final Object users = JSON.toJSON(tUsers);
        logger.debug(users.toString());
        return users.toString();
    }

    @RequestMapping("test4")
    public String test4() {

        return "{姓名:qq333q}";
    }

}
