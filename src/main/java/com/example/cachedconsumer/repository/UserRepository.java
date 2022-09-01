package com.example.cachedconsumer.repository;

import com.example.cachedconsumer.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Cacheable(value = "User")
public interface UserRepository extends CrudRepository<User, Long> {
List<User> findByBalanceValue (int value);

}
