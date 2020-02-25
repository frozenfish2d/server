package org.frozenfish.repos;

import org.frozenfish.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>, JpaRepository<User, Integer> {
    User findByUsername(String username);

}
