package com.dna.service.impl;

import com.dna.entity.Puppy;
import com.dna.service.RegisterService;
import com.dna.util.SerializeUtil;
import com.dna.util.StorageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by peng on 18/3/9.
 */
@Service("registerService")
@Transactional(readOnly = true)
public class RegisterServiceImpl implements RegisterService {

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public boolean register(Puppy puppy) {
        //to-do 修改为区块链自增
        String id = "";
        puppy.setId(id);

        //to-do 根据snp，查询得出该ID对应的父母ID
        String fatherId = "";
        String motherId = "";
        puppy.setFatherId(fatherId);
        puppy.setMotherId(motherId);

        byte[] parameter = SerializeUtil.toByteArray(puppy);
        if(parameter != null){
            if(StorageUtil.insert(id,parameter)) {
                return true;
            }
        }
        return false;
    }
}
