package com.my.dao;
import org.apache.ibatis.annotations.Param;
import com.my.model.User;
public interface UserDAO {
    public User selectOne(@Param("id")Integer id);
    
    public void insertOne(User user);
    
    public void deleteOne(@Param("id")Integer id);
    
    public void updateOne(User user);
}