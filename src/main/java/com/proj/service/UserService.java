package com.proj.service;

import java.util.List;
import com.proj.model.UserInfo;
import com.proj.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository repository;

    public UserInfo addUser(UserInfo user) {
        return repository.save(user);
    }

    public List<UserInfo> getAllUsers() {
        return repository.findAll();
    }

    public UserInfo getUserById(String id) {
        return repository.findById(id).get();
    }

    public UserInfo getUserByEmail(String mail) {
        return repository.findByMail(mail);
    }

    public UserInfo updateUser(UserInfo user) {
        UserInfo cur = repository.findById(user.getId()).get();
        cur.setMail(user.getMail());
        cur.setPassword(user.getPassword());
        return repository.save(cur);
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return id + " task deleted from dashboard";
    }

}
