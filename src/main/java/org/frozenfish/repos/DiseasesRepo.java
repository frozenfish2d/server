package org.frozenfish.repos;

import org.frozenfish.models.Disease;
import org.frozenfish.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DiseasesRepo extends CrudRepository<Disease, Integer>, JpaRepository<Disease, Integer> {


}
