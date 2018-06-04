package com.jd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jd.dao.specification.SpecificationDao;
import com.jd.dao.specification.SpecificationOptionDao;
import com.jd.pojo.specification.Specification;
import com.jd.pojo.specification.SpecificationOption;
import com.jd.pojo.specification.SpecificationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SpecificationSerivceImpl implements SpecificationSerivce {
    @Autowired
    SpecificationDao specificationDao;
    @Autowired
    SpecificationOptionDao specificationOptionDao;
    @Override


    public Page<Specification> findByWhere(Specification spec, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SpecificationQuery query = new SpecificationQuery();
        if(!StringUtils.isEmpty(spec.getSpecName()))
            query.createCriteria().andSpecNameLike(spec.getSpecName());
        Page<Specification> page = (Page<Specification>) specificationDao.selectByExample(query);
        return page;
    }

    @Transactional
    @Override
    public void insert(Specification record) {
        specificationDao.insertSelective(record);
        List<SpecificationOption> optionList = record.getSpecificationOptionList();
        for (SpecificationOption specificationOption : optionList) {
            specificationOption.setSpecId(record.getId());
            specificationOptionDao.insertSelective(specificationOption);
        }
    }

}
