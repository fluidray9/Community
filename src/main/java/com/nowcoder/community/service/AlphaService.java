package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AlphaService {

    public AlphaService(){
        System.out.println("instruction");
    }

    @PostConstruct
    public void init(){
        System.out.println("init AlphaService");
    }

    @Autowired
    private AlphaDao alphaDao;

    public String find(){
        return alphaDao.select();
    }

}
