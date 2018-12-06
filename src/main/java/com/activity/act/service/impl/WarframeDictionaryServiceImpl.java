package com.activity.act.service.impl;

import com.activity.act.DO.WarframeDictionary;
import com.activity.act.dao.WarframeDictionaryDao;
import com.activity.act.service.WarframeDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeDictionaryServiceImpl implements WarframeDictionaryService {
    @Autowired
    WarframeDictionaryDao warframeDictionaryDao;

    @Override
    public List<WarframeDictionary> findByZhLike(String zh) {
        return warframeDictionaryDao.findByZhLike(zh);
    }

    @Override
    public void insert(List<WarframeDictionary> wf) {
        System.out.println(wf);
        warframeDictionaryDao.saveAll(wf);
    }

    @Override
    public WarframeDictionary findById(long l) {
        return warframeDictionaryDao.findById(l).get();
    }

    @Override
    public void deleteAll() {
        warframeDictionaryDao.deleteAll();
    }
}
