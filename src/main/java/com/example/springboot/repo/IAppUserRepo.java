package com.example.springboot.repo;

import com.example.springboot.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser getAppUserByName (String name);
}
