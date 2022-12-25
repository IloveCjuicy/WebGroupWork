package com.example.experimentchapter45.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.experimentchapter45.Model.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodMapper extends BaseMapper<Good>
{
    @Select("SELECT * FROM good")
    List<Good> findAllGoods();
    @Insert({"insert into good(goodname,price,stock) value(#{goodname},#{price},#{stock})"})
    int insertGood(Good good);
    @Delete({"delete from good where id=${id}"})
    int deleteById(@Param("id")Integer id);
    @Delete({"delete from good where id >= ${id1} and id <=${id2}"})
    int BatchDelete(@Param("id1")Object id1,@Param("id2")Object id2);
    @Update({"update good set price=${price},stock=${stock} where id=${id}"})
    int updateById(@Param("price")Object price,@Param("stock")Object stock,@Param("id")Object id);
}
