package com.hhs.studybook.dao;

import com.hhs.studybook.entity.EnglishChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnglishRoomDao extends JpaRepository<EnglishChatRoom, Integer> {
}
