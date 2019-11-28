package com.wecanbetethis.diabetesapp.Models.Data;

import com.wecanbetethis.diabetesapp.Models.BloodSugar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BloodSugarDao extends CrudRepository<BloodSugar, Integer> {
}
