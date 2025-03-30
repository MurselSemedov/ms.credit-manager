package com.mursalsamad.dao.entity;

import com.mursalsamad.model.enums.CreditStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "status_histories")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StatusHistoryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @Enumerated(STRING)
    @Column(nullable = false)
    private CreditStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private CreditEntity credit;

}
