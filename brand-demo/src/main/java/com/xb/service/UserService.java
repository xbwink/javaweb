package com.xb.service;

import com.xb.bean.Brand;
import com.xb.bean.User;
import com.xb.mapper.BrandMapper;
import com.xb.mapper.UserMapper;
import com.xb.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {

    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 根据用户名和密码查询用户
     * @param userName
     * @param passWord
     * @return
     */
    public User login(String userName,String passWord){
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin(userName, passWord);
        //释放资源
        sqlSession.close();
        return user;
    }


    public boolean register(User user){
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //根据用户名判断用户是否存在
        User user1 = mapper.selectUserByName(user.getUsername());
        if(user1!=null){
            sqlSession.close();
            return false;
        }
        //执行添加用户
        mapper.register(user);
        sqlSession.close();
        return true;
    }

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return 存在返回true 不存在返回false
     */
    public boolean selectByName(String username) {
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置事务为自动提交
        //执行查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserByName(username);
        return user != null;
    }
}
