package com.fawry.crud.repository.EBPPConfigurationDAO;

import com.fawry.crud.entity.EBPP_CONFIGURATION.Configuration;
import com.fawry.crud.entity.EBPPCORE.compositePK.ConfigurationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, ConfigurationId> {

  Optional<Configuration> findByKey(String key);
}
