package com.mursalsamad.service.specification;
import com.mursalsamad.dao.entity.CustomerEntity;
import com.mursalsamad.model.criteria.CustomerCriteria;
import com.mursalsamad.util.PredicateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Data
@AllArgsConstructor
public class CustomerSpecification implements Specification<CustomerEntity> {

    private CustomerCriteria criteria;

    public Predicate toPredicate(Root<CustomerEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        var predicates = PredicateUtil.builder()
                .addWhenNullable(criteria.getFullName(),
                        fullName -> criteriaBuilder.like(root.get("fullName"),getLikePattern(fullName)))
                .addWhenNullable(criteria.getPin(),
                        pin -> criteriaBuilder.equal(root.get("pin"),pin))
                .addWhenNullable(criteria.getPhoneNumber(),
                        phoneNumber -> criteriaBuilder.equal(root.get("phoneNumber"),phoneNumber))
                .build();
        return criteriaBuilder.and(predicates);
    }

    private String getLikePattern(String searchingText){
        return "%" + searchingText + "%";
    }
}
