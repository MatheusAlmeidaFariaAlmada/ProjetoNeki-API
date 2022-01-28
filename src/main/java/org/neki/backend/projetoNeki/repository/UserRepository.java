package org.neki.backend.projetoNeki.repository;

import org.neki.backend.projetoNeki.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

}
