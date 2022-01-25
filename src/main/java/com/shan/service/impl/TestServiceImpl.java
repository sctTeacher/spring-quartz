package com.shan.service.impl;

import com.shan.mapper.TestMapper;
import com.shan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    //验证事务
    @Override
   @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        HashMap param =new HashMap();
        param.put("id","1");
        param.put("name","哈哈");
        testMapper.updateById(param);
        int i = 5/0;
        param.put("id","1");
        param.put("name","哈哈11111");
        testMapper.updateById(param);
    }
}
