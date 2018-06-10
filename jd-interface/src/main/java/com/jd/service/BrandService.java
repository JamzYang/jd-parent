package com.jd.service;

import com.github.pagehelper.PageInfo;
import com.jd.pojo.good.Brand;
import java.util.List;
import java.util.Map;

public interface BrandService {
    void insert(Brand brand);

    Brand findByKey(Long id);

    List<Brand> findAll();

    void update(Brand brand);

    void delete(Long[] ids);
    PageInfo<Brand> findByWhere(Brand brand, Integer pageNum, Integer pageSize);

    List<Map> selectOptionList();
}
