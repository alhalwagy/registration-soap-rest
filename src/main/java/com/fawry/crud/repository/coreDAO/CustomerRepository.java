package com.fawry.crud.repository.coreDAO;

import com.fawry.crud.entity.EBPPCORE.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    <S extends Customer> List<S> findAll(Example<S> example);
}
