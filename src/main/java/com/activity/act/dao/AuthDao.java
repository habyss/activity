package com.activity.act.dao;

import com.activity.act.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDao extends JpaRepository<Auth,Long>, JpaSpecificationExecutor {
    Auth findByUsernameAndPassword(String username, String password);
}
