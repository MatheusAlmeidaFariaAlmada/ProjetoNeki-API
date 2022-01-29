package org.neki.backend.projetoNeki.repository;

import org.neki.backend.projetoNeki.entity.UserSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends JpaRepository <UserSkillEntity, Long> {

}
