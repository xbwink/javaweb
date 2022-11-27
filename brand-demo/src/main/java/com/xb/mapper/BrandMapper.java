package com.xb.mapper;

import com.xb.bean.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //根据id查询
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(Integer id);

    //新增
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName}, #{ordered},#{description},#{status});")
    void add(Brand brand);

    //修改
   // @Update("update set tb_brand brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status=#{status} where id = #{id}")
    void update(Brand brand);

    //删除
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(Integer id);
}
