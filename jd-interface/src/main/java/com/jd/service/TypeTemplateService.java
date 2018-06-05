package com.jd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jd.pojo.template.TypeTemplate;

import java.util.List;

public interface TypeTemplateService {
    void insert(TypeTemplate record);

    void delete(Long[] ids);

    void update(TypeTemplate record);

    TypeTemplate findByKey(Long id);

    List<TypeTemplate> findAll();

    Page<TypeTemplate> findByWhere(TypeTemplate typeTemplate, Integer pageNum, Integer pageSize);
}
