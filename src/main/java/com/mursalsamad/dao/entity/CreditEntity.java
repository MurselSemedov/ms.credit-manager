package com.mursalsamad.dao.entity;
import com.mursalsamad.model.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private BigDecimal amount;
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal requestedAmount;
    @Enumerated(STRING)
    private CreditStatus status;
    private LocalDateTime checkDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = LAZY)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "credit", cascade = {PERSIST,MERGE})
    private List<StatusHistoryEntity> statusHistories;

    @OneToMany(mappedBy = "credit", cascade = {PERSIST,MERGE})
    private List<OfferEntity> offers;

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreditEntity that = (CreditEntity) o;
        return Objects.equals(id, that.id);
    }

    public int hashCode() {
        return Objects.hashCode(id);
    }
}
