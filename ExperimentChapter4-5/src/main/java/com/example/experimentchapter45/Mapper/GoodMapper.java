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
    @Insert({"insert into good value(#{goodname},#{price},#{stock})"})
    int insertGood(Good good);
    @Delete({"delete from good where id=${id}"})
    int deleteById(@Param("id")Integer id);
    @Update({"update good set price=${price},stock=${stock} where id=${id}"})
    int updateById(@Param("price")Double price,@Param("stock")Integer stock,@Param("id")Integer id);
}
