package com.jdc.pos.model.service;

import com.jdc.pos.model.PosException;
import com.jdc.pos.model.entity.Account;
import com.jdc.pos.model.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {

    @Autowired
    private AccountRepo repo;

    public Account login(String loginId, String password) {

        if(StringUtils.isEmpty(loginId)) {
            throw new PosException("Введите логин.");
        }

        if(StringUtils.isEmpty(password)) {
            throw new PosException("Введите пароль.");
        }

        Account account = repo.findById(loginId)
                .orElseThrow(() -> new PosException("Проверьте ваш логин"));

        if(!password.equals(account.getPassword())) {
            throw new PosException("Проверьте ваш пароль");
        }

        return account;
    }
}
