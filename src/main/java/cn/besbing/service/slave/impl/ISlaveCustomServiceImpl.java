package cn.besbing.service.slave.impl;

import cn.besbing.mapper.slave.SlaveCustom;
import cn.besbing.service.slave.ISlaveCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISlaveCustomServiceImpl implements ISlaveCustomService {

    @Autowired(required = false)
    SlaveCustom slaveCustom;

    public String TestConnection(){
        return slaveCustom.selectOne("select * from dual");
    }

}
