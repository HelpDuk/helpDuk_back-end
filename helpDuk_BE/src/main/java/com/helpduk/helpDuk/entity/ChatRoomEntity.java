package com.helpduk.helpDuk.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.config.Task;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="chatroom")
public class ChatRoomEntity {
    @Id
    private String roomId;


    @JsonCreator
    public ChatRoomEntity(@JsonProperty("roomId") String roomId) {
        this.roomId = roomId;
    }

    public static ChatRoomEntity create(String name) {
        ChatRoomEntity room = new ChatRoomEntity(UUID.randomUUID().toString());
        return room;
    }

    @ManyToOne
    @JoinColumn(name = "task")
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "helper")
    private UserEntity helper;

}
