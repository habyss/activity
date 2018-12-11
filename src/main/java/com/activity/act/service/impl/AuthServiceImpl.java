package com.activity.act.service.impl;

import com.activity.act.dao.AuthDao;
import com.activity.act.entity.Auth;
import com.activity.act.service.AuthService;
import com.activity.act.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthDao authDao;

    @Override
    public Auth getAuthInfo(Auth auth) {
        auth.setPassword(MD5Utils.getPassword(auth.getPassword()));
        return authDao.findByUsernameAndPassword(auth.getUsername(),auth.getPassword());
    }
}
