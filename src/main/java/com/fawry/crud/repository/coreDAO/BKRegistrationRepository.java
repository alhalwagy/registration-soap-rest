package com.fawry.crud.repository.coreDAO;

import java.util.List;
import java.util.Optional;

import com.fawry.crud.entity.EBPPCORE.BKRegistration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BKRegistrationRepository extends PagingAndSortingRepository<BKRegistration, Long> {

  @Query(
      value =
          "SELECT * FROM ( "
              + "  SELECT a.*, ROWNUM rnum FROM ( "
              + "    SELECT * FROM bk_registration "
              + "    ORDER BY id "
              + "  ) a "
              + "  WHERE ROWNUM <= :endRow "
              + ") "
              + "WHERE rnum > :startRow",
      nativeQuery = true)
  List<BKRegistration> findAll(@Param("startRow") int startRow, @Param("endRow") int endRow);

  Optional<BKRegistration> findById(Long id);


  BKRegistration save(BKRegistration bkRegistration);

//  @Modifying
//  @Query("UPDATE BK_REGISTRATION b SET " +
//          "b.companyName = :companyName, " +
//          "b.jobTitle = COALESCE(:jobTitle, b.jobTitle) " +
//          "WHERE b.id = :id")
//  void updateBKRegistration(
//          @Param("id") Long id,
//          @Param("companyName") String companyName,
//          @Param("jobTitle") String jobTitle);

  void deleteById(Long id);
}
