package com.jd.dao.seckill;

import com.jd.pojo.seckill.SeckillOrder;
import com.jd.pojo.seckill.SeckillOrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeckillOrderDao {
    int countByExample(SeckillOrderQuery example);

    int deleteByExample(SeckillOrderQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    List<SeckillOrder> selectByExample(SeckillOrderQuery example);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillOrder record, @Param("example") SeckillOrderQuery example);

    int updateByExample(@Param("record") SeckillOrder record, @Param("example") SeckillOrderQuery example);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);
}