package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserInfo;
import com.example.demo.service.UsersService;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Autowired
	private UsersService usersService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	//private RedisTemplate<Object,UserInfo> userInfoRedisTemplate;

	/*@Test
	public void contextLoads() {
		stringRedisTemplate.opsForList().leftPush("mylist","1");
		stringRedisTemplate.opsForList().leftPush("mylist","2");
		stringRedisTemplate.opsForList().leftPush("mylist","3");
		List<String> mylist = stringRedisTemplate.opsForList().range("mylist", 0, -1);
		mylist.stream().forEach(System.out::println);
	}*/

	/*@Test
	public void contextLoads1() {
		UserInfo user = userService.getUser(1);
		userInfoRedisTemplate.opsForValue().set("user-1",user);
	}*/
	@Test
	public void contextLoads2() {
		User admin = usersService.findByUsername("admin");
		System.out.println(admin);
	}

}
