package com.my.dao.test;

import static org.junit.Assert.*;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.my.dao.UserDAO;
import com.my.model.User;
//2014-7-10
public class UserDAOTest {

	private static SqlSessionFactory sqlSessionFactory;
	//SqlSession ���󼶱�ģ�ÿ�������½�һ������Ҫ���óɾ�̬��,ÿ���������ر�,
	//insert update delete ���뿪�����񣬲���commit���ܱ��浽��ݿ���
	//static SqlSession session = null;
	 UserDAO userDao = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			Reader reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectOne() {
		// fail("Not yet implemented");
		SqlSession session = sqlSessionFactory.openSession();
		userDao = session.getMapper(UserDAO.class);
		User user = userDao.selectOne(3);
		if (user != null) {
			System.out.println("Name=" + user.getName());
		}
		session.close();
		Assert.assertNotNull(user);
	}

	@Test
	public void testInsertOne() {
		SqlSession session = sqlSessionFactory.openSession();
		userDao = session.getMapper(UserDAO.class);
		User user = new User();
		user.setName("test77");
		user.setAge(7);
		userDao.insertOne(user);
		session.commit();
		session.close();
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteOne() {
		SqlSession session = sqlSessionFactory.openSession();
		userDao = session.getMapper(UserDAO.class);
		userDao.deleteOne(1);
		session.commit();
		session.close();
		Assert.assertTrue(true);
	}

	@Test
	public void testUpdateOne() {
		SqlSession session = sqlSessionFactory.openSession();
		userDao = session.getMapper(UserDAO.class);
		User user = new User();
		user.setId(3);
		user.setAge(7);
		user.setName("name77");
		userDao.updateOne(user);
		session.commit();
		session.close();
		Assert.assertTrue(true);
	}

}
