package com.jd.service;

import com.github.pagehelper.Page;
import com.jd.pojo.specification.Specification;

import java.util.List;

public interface SpecificationSerivce {
    Page<Specification> findByWhere(Specification spec, Integer pageNum, Integer pageSize);
    void insert(Specification record);
    void update(Specification record);
    void delete(Long id);
    List<Specification> findAll();
    Specification findByKey(Long id);
}
