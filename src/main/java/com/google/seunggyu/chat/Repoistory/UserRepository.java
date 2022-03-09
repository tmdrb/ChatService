package com.google.seunggyu.chat.Repoistory;

import com.google.seunggyu.chat.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
