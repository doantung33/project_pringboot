package com.example.springboot.service;

import com.example.springboot.model.AppUser;

public interface IAppUserService {
    AppUser getUserByName(String name);
}
