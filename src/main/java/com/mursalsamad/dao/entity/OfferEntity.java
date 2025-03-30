package com.mursalsamad.dao.entity;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "offers")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private int term;
    @Column(nullable = false)
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private Boolean accepted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ToString.Exclude
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = LAZY)
    private CreditEntity credit;
}
