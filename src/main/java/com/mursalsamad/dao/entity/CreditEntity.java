package com.mursalsamad.dao.entity;

import com.mursalsamad.model.enums.CreditStatus;
import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "credits")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private BigDecimal amount;
    private int term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    @Column(nullable = false)
    private BigDecimal requestedAmount;
    @Enumerated(STRING)
    @Column(nullable = false)
    private CreditStatus status;
    @Column(nullable = false)
    private LocalDateTime checkDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private CustomerEntity customer;
    @OneToMany(cascade = {PERSIST,MERGE})
    @ToString.Exclude
    private List<StatusHistoryEntity> status_histories;

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreditEntity that = (CreditEntity) o;
        return id == that.id;
    }

    public int hashCode() {
        return Objects.hashCode(id);
    }
}
