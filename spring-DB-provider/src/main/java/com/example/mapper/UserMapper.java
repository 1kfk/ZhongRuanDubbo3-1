package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.bean.User;
//注入mapper
@Mapper
public interface UserMapper {
	@Results({
		@Result(property = "id",column = "id",id = true),
		@Result(property = "username",column = "username"),
		@Result(property = "password",column = "password")
	})
	@Select("select * from user where username like concat('%',#{find},'%')")
	List<User> getAllUser(String find);
	@Results({
		@Result(property = "id",column = "id",id = true),
		@Result(property = "username",column = "username"),
		@Result(property = "password",column = "password")
	})
	@Select("select * from user where username=#{username}")
	User getUser(String username);
	@Insert("insert into user values(#{id},#{username},#{password})")
	int insertUser(User user);
	@Update("update user set username=#{username},password=#{password} where id= #{id}")
	int updateUser(User user);
	@Delete("delete from user where id=#{id} or username=#{username}")
	int deleteUser(@Param("id") int id,@Param("username") String username);
}
