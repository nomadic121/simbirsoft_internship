package org.nomadic121.chat.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne
    //    @JoinColumn(name = "creator_id")
    @Column(name = "owner")
    private String from;

    @Column(name = "text")
    private String message;

}