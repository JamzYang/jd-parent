package com.jd.dao.seller;

import com.jd.pojo.seller.Seller;
import com.jd.pojo.seller.SellerQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerDao {
    int countByExample(SellerQuery example);

    int deleteByExample(SellerQuery example);

    int deleteByPrimaryKey(String sellerId);

    int insert(Seller record);

    int insertSelective(Seller record);

    List<Seller> selectByExample(SellerQuery example);

    Seller selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") Seller record, @Param("example") SellerQuery example);

    int updateByExample(@Param("record") Seller record, @Param("example") SellerQuery example);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}