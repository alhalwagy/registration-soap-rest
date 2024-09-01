package com.fawry.crud.repository;

import com.fawry.crud.entity.BKRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BKRegistrationRepository extends PagingAndSortingRepository<BKRegistration, Long> {

    @Query(value = "SELECT * FROM ( " +
            "  SELECT a.*, ROWNUM rnum FROM ( " +
            "    SELECT * FROM bk_registration " +
            "    ORDER BY id " +
            "  ) a " +
            "  WHERE ROWNUM <= :endRow " +
            ") " +
            "WHERE rnum > :startRow", nativeQuery = true)
    List<BKRegistration> findAll(@Param("startRow") int startRow, @Param("endRow") int endRow);

    Optional<BKRegistration> findById(Long id);

    BKRegistration save(BKRegistration bkRegistration);

    void deleteById(Long id);
}