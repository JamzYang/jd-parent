package com.jd.service;

import com.github.pagehelper.Page;
import com.jd.pojo.specification.Specification;

public interface SpecificationSerivce {
    Page<Specification> findByWhere(Specification spec, Integer pageNum, Integer pageSize);

    void insert(Specification record);
}
