package com.hhs.studybook.dao;

import com.hhs.studybook.entity.MathChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MathRoomDao extends JpaRepository<MathChatRoom, Integer> {
}
