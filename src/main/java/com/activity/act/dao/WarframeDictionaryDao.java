package com.activity.act.dao;

import com.activity.act.entity.WarframeDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarframeDictionaryDao extends JpaRepository<WarframeDictionary,Long>, JpaSpecificationExecutor {
    List<WarframeDictionary> findByZhLike(String zh);
}
