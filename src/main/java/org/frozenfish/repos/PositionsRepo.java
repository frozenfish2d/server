package org.frozenfish.repos;

import org.frozenfish.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PositionsRepo extends CrudRepository<Position, Integer>, JpaRepository<Position, Integer> {


}
