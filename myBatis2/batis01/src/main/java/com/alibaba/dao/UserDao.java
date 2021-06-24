package com.alibaba.dao;

import com.alibaba.pojo.User;

import java.util.List;

/**
 * @author kylinWang
 * @data 2021/5/12 22:25
 */


/*
 * 1.Mybatis介绍
 * 		是一个java编写的轻量级半自动的ORM映射的持久化层框架。
 *      fixme: 半自动
 *
 * 		Object Relitional Mapping(对象关系映射)：  将java的对象和关系型数据库中的记录一一对象
 *
 * 		半自动：  相对于全自动。需要程序员编写sql! Dao层框架，会帮助程序员完成编写SQL之后的所有事情！
 *
 * 		全自动：  Hibernate。 当使用Hibernate时，创建一个java对象，调用Hibernate的API，自动将
 * 				java对象，保存到数据库中！
 * 				程序员可以不会SQL语句！完成数据的增删改查！
 *
 * 		随着历史的发展，Hibernate被逐渐淘汰！原因随着业务逻辑的复杂和项目的升级，需要随时调整或优化SQL语句。
 * 			如果使用全自动的框架，优化的成本较高！
 *
 * 	2.Mybatis的特点
 * 			Mybatis 推崇将sql语句编写在一个xml文件中，和业务代码（java)分离。
 * 				二者通过配置的方式，有机结合（java代码读到sql语句）；
 * 				提高项目的可维护性！分层解耦！
 *
 * 		版本的迭代：   最先叫ibatis，是Google旗下
 * 				从2.0后，转投Apache旗下，改名Mybatis，从3.0
 * 3. 使用
 * 			①导入jar包
 * 			②从 mybatis全局的配置文件 中构建 SqlSessionFactory
 *
 * 				 SqlSessionFactory负责创建SqlSession；
 * 				SqlSession类似与JDBC中的connection，代表和数据库的一次对话（链接）。
 *
 * 				a）准备全局配置文件，配置数据库的环境
 * 				b)导入mysql驱动
 *
 * 			③通过代码创建一个 SqlSessionFactory
 * 			④通过SqlSessionFactory，创建一个sqlsession
 * 			⑤准备POJO，编写sql语句所在的xml文件
 * 			⑥在mybatis-config.xml中注册之前编写的sql语句所在的xml文件
 * 			⑦调用sqlsession的api，传入sql语句的id和参数，执行！
 *
 * 4. 常见错误：
 * 		Mapped Statements collection
 * 		does not contain value for myemployee.selectEmp
 *
 * 		通常是xml中的sql语句没有被系统识别，没有配置好！
 *
 *
 *
 */


//定义接口，返回数据类型
public interface UserDao {
    List<User> getUserList();
}
