package com.heating.system.commons.jpa;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseRepository {

    @PersistenceContext
    protected EntityManager em;
    protected CriteriaBuilder cb;

    @PostConstruct
    protected void initCriteriaBuilder() {
        cb = em.getCriteriaBuilder();
    }

    protected static <R> Optional<R> checkForSingleResult(List<R> resultList) {
        if (resultList.size() > 1) {
            throw new AssertionError("More than one result found");
        } else {
            return resultList.isEmpty() ? Optional.empty() : Optional.ofNullable(resultList.get(0));
        }
    }

}
