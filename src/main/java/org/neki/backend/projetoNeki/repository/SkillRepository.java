package org.neki.backend.projetoNeki.repository;

import org.neki.backend.projetoNeki.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <SkillEntity, Long> {

}
