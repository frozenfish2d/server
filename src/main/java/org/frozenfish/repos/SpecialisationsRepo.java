package org.frozenfish.repos;

import org.frozenfish.models.Disease;
import org.frozenfish.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpecialisationsRepo extends CrudRepository<Specialization, Integer>, JpaRepository<Specialization, Integer> {


}
