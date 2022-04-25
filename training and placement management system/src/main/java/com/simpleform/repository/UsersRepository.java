package com.simpleform.repository;

import java.util.Optional;

import com.simpleform.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel, Integer>{

    //Optional<UsersModel> findByLoginAndPasswordAOptional(String login, String password, String role);
    //Optional<UsersModel> (String login, String password, String role);

    Optional<UsersModel> findByLoginAndPassword(String login, String password);

    Optional<UsersModel> findFirstByLogin(String login);

}
