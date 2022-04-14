package com.nowcoder.community.dao;

import org.springframework.stereotype.Component;

@Component("alphaHibernate")
public class AlphaDaoHibernate implements AlphaDao{
    @Override
    public String select() {
        return "hello Hibernate!";
    }
}
