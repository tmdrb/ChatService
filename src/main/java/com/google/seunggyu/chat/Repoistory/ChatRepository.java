package com.google.seunggyu.chat.Repoistory;

import com.google.seunggyu.chat.Model.ChatDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatDTO,Long> {
}
