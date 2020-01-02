package com.wecanbetethis.diabetesapp.Models.Data;

import com.wecanbetethis.diabetesapp.Models.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface BlogDao extends CrudRepository<Blog, Integer> {
}
