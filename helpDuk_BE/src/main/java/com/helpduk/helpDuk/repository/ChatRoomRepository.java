package com.helpduk.helpDuk.repository;

import com.helpduk.helpDuk.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, String> {
    Optional<ChatRoomEntity> findByRoomId(String id);
}