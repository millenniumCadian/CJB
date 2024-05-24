package com.example.csj_firstproject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import zc.Entity.Department;
import zc.Entity.User;
import zc.Mapper.DepartmentMapper;
import zc.Mapper.UserMapper;
import zc.Vo.DeptVo;
import zc.Vo.UserVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoTest {
    private static SqlSession getSqlSession(){
        InputStream is=null;
        try {
            is= Resources.getResourceAsStream("mybatis-config.xml");
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        return sqlSessionFactory.openSession(true);
    }

    @Test
    public void findDeptAllUser(){
        SqlSession sqlSession=getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        DeptVo department=departmentMapper.findDeptAllUser(1);
        System.out.println(department);
    }

    @Test
    public void getAllUserWithDepartment(){
        SqlSession sqlSession=getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserVo> userVo=userMapper.getAllUserWithDepartment();
        userVo.forEach(System.out::println);
    }

    @Test
    public void getUserWithDepartment(){
        SqlSession sqlSession=getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserVo userVo= userMapper.getUserWithDepartment(1);
        System.out.println(userVo);
    }
}

