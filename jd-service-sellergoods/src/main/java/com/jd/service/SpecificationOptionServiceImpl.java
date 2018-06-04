package com.jd.service;

import com.jd.dao.specification.SpecificationOptionDao;
import com.jd.pojo.specification.SpecificationOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {
    @Autowired
    SpecificationOptionDao specificationOptionDao;
    @Override
    public void insert(SpecificationOption record) {
        specificationOptionDao.insertSelective(record);
    }

    @Override
    public void delete(Long id) {

    }
}
