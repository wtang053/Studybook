package com.hhs.studybook.dao;

import com.hhs.studybook.entity.ElectiveChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ElectiveRoomDao extends JpaRepository<ElectiveChatRoom, Integer> {
}
