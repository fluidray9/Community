package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AlphaDaoMybatis implements AlphaDao{

    @Override
    public String select() {
        return "hello Mybatis";
    }

}
