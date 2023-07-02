package com.Connect_CC.Registration.dao;

import com.Connect_CC.Registration.entity.RegEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RegRepo extends JpaRepository<RegEntity,Long>{


//    @Query("SELECT e FROM RegEntity WHERE emailId = nav@gmail.com")
//    public List<RegEntity> findByEmail(String email);


//    @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",
//  nativeQuery = true)
//User findUserByStatusAndNameNamedParamsNative(
//  @Param("status") Integer status, @Param("name") String name);:emailId
    @Query(value = "SELECT * FROM Reg_Table r WHERE r.EMAIL_ID = :emailId ",
            nativeQuery = true)
     List<RegEntity> findByEmail(
            @Param("emailId") String emailId);

    // Both Reg_table and REG_TABLE working fine  and use REG_TABLE if in entity given table name other wise instead of Reg_Table use entity name which is REG_ENTITY . Check db for this
    @Query(value = "SELECT r.REG_ID FROM Reg_Table r WHERE r.EMAIL_ID = :emailId",
            nativeQuery = true)
        Long findRegId(
            @Param("emailId") String emailId);

//    @Query("SELECT u FROM User u WHERE u.status = 1")
//    List<RegEntity> finAdllActiveUsers();


}
