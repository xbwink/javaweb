package com.xb.service;

import com.xb.bean.Brand;
import com.xb.mapper.BrandMapper;
import com.xb.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandsService {

    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //查询所有
    public List<Brand> selectAll() {

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行查询
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        //释放资源
        sqlSession.close();
        return brands;
    }

    //根据id查询
    public Brand selectById(Integer id){
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行查询
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);

        //释放资源
        sqlSession.close();
        return brand;
    }

    //新增
    public void addBrand(Brand brand){
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行新增
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        //释放资源
        sqlSession.close();
    }

    //修改
    public void update(Brand brand){
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行新增
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        //释放资源
        sqlSession.close();
    }

    //删除
    public void deleteById(Integer id){
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行新增
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        //释放资源
        sqlSession.close();
    }

}
