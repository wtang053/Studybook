package com.hhs.studybook.dao;

import com.hhs.studybook.entity.ScienceChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScienceRoomDao extends JpaRepository<ScienceChatRoom, Integer> {
}
