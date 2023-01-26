package com.heating.system.iotdevice.repository;

import com.heating.system.commons.jpa.AbstractBaseRepository;
import com.heating.system.iotdevice.model.Measurement;
import com.heating.system.iotdevice.model.Measurement_;
import com.heating.system.iotdevice.model.Plant_;

import javax.persistence.criteria.Predicate;
import java.time.ZonedDateTime;
import java.util.List;

public class MeasurementCustomRepositoryImpl extends AbstractBaseRepository implements MeasurementCustomRepository {

    public List<Measurement> findAllByPlantIdAndDateBetween(Long plantId, ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        var query = cb.createQuery(Measurement.class);
        var root = query.from(Measurement.class);
        var plantJoin = root.join(Measurement_.plant);

        Predicate dateFromPredicate = cb.and();
        if(dateFrom != null) {
            dateFromPredicate = cb.greaterThanOrEqualTo(root.get(Measurement_.timestamp), dateFrom);
        }

        Predicate dateToPredicate = cb.and();
        if(dateFrom != null) {
            dateToPredicate = cb.lessThanOrEqualTo(root.get(Measurement_.timestamp), dateTo);
        }

        query.select(root);
        query.where(cb.and(
                cb.equal(plantJoin.get(Plant_.id), plantId),
                dateFromPredicate,
                dateToPredicate
        ));

        return em.createQuery(query).getResultList();
    }
}
