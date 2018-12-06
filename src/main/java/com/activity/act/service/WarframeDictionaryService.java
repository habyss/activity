package com.activity.act.service;

import com.activity.act.DO.WarframeDictionary;

import java.util.List;


public interface WarframeDictionaryService {
    List<WarframeDictionary> findByZhLike(String zh);

    void insert(List<WarframeDictionary> wf);

    WarframeDictionary findById(long l);

    void deleteAll();
}
