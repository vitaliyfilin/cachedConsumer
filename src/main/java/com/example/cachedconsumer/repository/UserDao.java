package com.example.cachedconsumer.repository;

import com.example.cachedconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Cacheable(value = "User")
public class UserDao {
    public static final String HASH_KEY = "User";

   //@Autowired
   //private RedisTemplate template;

   //public User save(User user){
   //   // template.opsForHash().put(HASH_KEY,user.getId(),user);
   //    return user;
   //}

   //public List<User> findAll(){
   //    return template.opsForHash().values(HASH_KEY);
   //}

   //public User findUserByID(int id){
   //    System.out.println("called findProductById() from DB");
   //    return (User) template.opsForHash().get(HASH_KEY,id);
   //}


   //public String deleteProduct(int id){
   //    template.opsForHash().delete(HASH_KEY,id);
   //    return "user removed !!";
   //}
}


