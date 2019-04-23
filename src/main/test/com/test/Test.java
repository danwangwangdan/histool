//package com.test;
//
//import com.xhrmyy.histool.HisToolApplication;
////import org.jasypt.encryption.StringEncryptor;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = HisToolApplication.class)
//public class Test {
//    private static final Logger log = LoggerFactory.getLogger(Test.class);
//    //根据上面配的盐值自动注入
//    @Autowired
//    StringEncryptor stringEncryptor;
//
//    @org.junit.Test
//    public void encryptPwd() {
//        String password = "wlzx520";//要加密的密码
//        String result = stringEncryptor.encrypt(password);
//        //打印结果
//        log.info("加密值："+ result);//j+LyKbfM+rvC2WUMY+h3rg==
//    }
//    @org.junit.Test
//    public void encryptUsr() {
//        String password = "pdjh";//要加密的密码
//        String result = stringEncryptor.encrypt(password);
//        //打印结果
//        log.info("加密值："+ result);//j+LyKbfM+rvC2WUMY+h3rg==
//    }
//}
