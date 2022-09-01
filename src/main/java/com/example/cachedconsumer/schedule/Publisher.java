package com.example.cachedconsumer.schedule;

import com.example.cachedconsumer.model.Balance;
import com.example.cachedconsumer.repository.UserDao;
import com.example.cachedconsumer.repository.UserRepository;
import com.example.cachedconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Publisher {
    @Autowired
    UserService userDao;
    @Scheduled(fixedDelay = 10000L)
    public void publishBalance () {
        int value = 100;
        //userDao.getUsersByBalanceValue().stream().filter(x -> x.getBalance().getValue() > 0).forEach(System.out::println);
        //userDao.getUsersByBalanceValue().forEach(System.out::println);
        System.out.println(userDao.getUserById(2L));
    }

}
