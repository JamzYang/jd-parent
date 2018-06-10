package com.jd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jd.dao.template.TypeTemplateDao;
import com.jd.pojo.template.TypeTemplate;
import com.jd.pojo.template.TypeTemplateQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
@Transactional
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    TypeTemplateDao typeTemplateDao;
    @Override
    public void insert(TypeTemplate record) {
        typeTemplateDao.insertSelective(record);
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public void update(TypeTemplate record) {

    }

    @Override
    public TypeTemplate findByKey(Long id) {
        return typeTemplateDao.selectByPrimaryKey(id);
    }

    @Override
    public List<TypeTemplate> findAll() {
        return null;
    }

    @Override
    public Page<TypeTemplate> findByWhere(TypeTemplate typeTemplate, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TypeTemplateQuery query = new TypeTemplateQuery();
        if(!StringUtils.isEmpty(typeTemplate.getName()))
            query.createCriteria().andNameLike(typeTemplate.getName());
        Page<TypeTemplate> page = (Page)typeTemplateDao.selectByExample(query);
        return page;
    }
}
