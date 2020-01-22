package com.wecanbetethis.diabetesapp.Models.Data;

import com.wecanbetethis.diabetesapp.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findByEmail(String email);
    User findByUsername(String username);
}

