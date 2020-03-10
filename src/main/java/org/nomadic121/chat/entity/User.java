package org.nomadic121.chat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"banned", "hashPass", "createdChats"})
@Entity
@Table(name = "chat_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private @NonNull String name;

    private @NonNull String hashPass;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    Role roles;

    private boolean banned;

    @OneToMany(mappedBy = "creator")
    private Set<Chat> createdChats;

}