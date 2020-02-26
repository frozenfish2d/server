package org.frozenfish.repos;

import org.frozenfish.models.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpecialisationsRepo extends CrudRepository<Specialisation, Integer>, JpaRepository<Specialisation, Integer> {


}
