package com.xb.mapper;

import com.xb.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     *根据用户名密码查询用户对象
     */
    @Select("select * from tb_user where username = #{userName} and password = #{passWord}")
    User checkLogin(@Param("userName") String name,@Param("passWord") String pwd);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from tb_user where username = #{userName}")
    User selectUserByName(String userName);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into tb_user(username,password) values(#{username},#{password})")
    void register(User user);

}
