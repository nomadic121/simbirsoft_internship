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
@Table(name = "chat_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private @NonNull String name;

    private @NonNull String hashPass;

    private boolean banned;

    @OneToMany(mappedBy = "creator")
    private List<Chat> createdChats;

}