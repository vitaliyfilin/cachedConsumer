package com.example.cachedconsumer.service;

import com.example.cachedconsumer.model.User;
import com.example.cachedconsumer.repository.UserDao;
import com.example.cachedconsumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userDao;

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    @Cacheable(cacheNames = "users")
    public List<User> getUsersByBalanceValue() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Cacheable(cacheNames = "user", key = "#id", condition = "#result.id > 2")
    public User getUserById(Long id) {
        return userDao.findById(id).get();
    }


}
