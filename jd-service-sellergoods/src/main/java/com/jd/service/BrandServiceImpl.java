package com.jd.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.dao.good.BrandDao;
import com.jd.pojo.good.Brand;
import com.jd.pojo.good.BrandQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Transactional
    @Override
    public void insert(Brand brand) {
        brandDao.insertSelective(brand);
    }

    @Override
    public Brand findByKey(Long id) {
        return brandDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandDao.selectByExample(null);
    }

    @Transactional
    @Override
    public void update(Brand brand) {
        brandDao.updateByPrimaryKey(brand);
    }


    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandDao.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageInfo<Brand> findByWhere(Brand brand, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        BrandQuery query = new BrandQuery();
        if(!StringUtils.isEmpty(brand.getName())){
            query.createCriteria().andNameLike(brand.getName());
        }
        if(!StringUtils.isEmpty(brand.getFirstChar()))
            query.createCriteria().andFirstCharEqualTo(brand.getFirstChar());
        Page<Brand> page =(Page<Brand>) brandDao.selectByExample(query);
        return page.toPageInfo();
    }
}
