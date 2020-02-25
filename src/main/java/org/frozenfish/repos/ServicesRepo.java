package org.frozenfish.repos;

import org.frozenfish.models.Disease;
import org.frozenfish.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ServicesRepo extends CrudRepository<Service, Integer>, JpaRepository<Service, Integer> {


}
