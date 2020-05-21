package cn.besbing.service.primary.impl;

import cn.besbing.mapper.primary.PrimaryCustom;
import cn.besbing.service.primary.IPrimaryCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPrimaryCustomServiceImpl implements IPrimaryCustomService {

    @Autowired(required = false)
    PrimaryCustom primaryCustom;

    public String TestConnection(){
        return primaryCustom.selectOne("select * from dual");
    }
}
