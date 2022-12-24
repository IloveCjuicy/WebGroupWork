package com.example.experimentchapter45.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.experimentchapter45.Model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User>
{
    @Select("SELECT * FROM user")
    List<User> findAllUsers();
    @Insert({"insert into `user`(username,password) value(#{username},#{password})"})
    int insertUser(User user);

    @Delete({"delete from `user` where username=#{username} and password=#{password}"})
    int deleteUser(User user);

    @Update({"update `user`  set password=#{password} where username=#{username}"})
    int updateUser(User user);
}
