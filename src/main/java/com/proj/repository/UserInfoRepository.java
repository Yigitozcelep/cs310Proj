package com.proj.repository;

import com.proj.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
    UserInfo findByMail(String email);
}
