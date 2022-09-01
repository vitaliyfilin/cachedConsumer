package com.example.cachedconsumer.service;

import com.example.cachedconsumer.model.User;
import com.example.cachedconsumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
  User saveUser (User user);
  List<User> getUsersByBalanceValue ();

  User getUserById (Long id);
}
