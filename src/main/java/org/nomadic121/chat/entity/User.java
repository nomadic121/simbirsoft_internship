package org.nomadic121.chat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table( name = "chat_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NonNull String name;

    private @NonNull String hashPass;

    @OneToMany(mappedBy = "creator")
    private List<Chat> createdChats;

}