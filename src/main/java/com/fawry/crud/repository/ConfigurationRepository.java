package com.fawry.crud.repository;

import com.fawry.crud.entity.Configuration;
import com.fawry.crud.entity.compositePK.ConfigurationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, ConfigurationId> {

  Optional<Configuration> findByKey(String key);
}
