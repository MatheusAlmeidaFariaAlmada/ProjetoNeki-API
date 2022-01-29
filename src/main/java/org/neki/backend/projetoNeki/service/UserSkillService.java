package org.neki.backend.projetoNeki.service;

import org.neki.backend.projetoNeki.entity.UserSkillEntity;
import org.neki.backend.projetoNeki.repository.UserSkillRepository;
import org.neki.backend.projetoNeki.vo.UserSkillExibirVO;
import org.neki.backend.projetoNeki.vo.UserSkillInserirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {

	@Autowired
	UserSkillRepository userSkillRepository;
	
	// atualizar
	public UserSkillExibirVO atualizar(Long id, UserSkillInserirVO userSkillInserirVO) {
		UserSkillEntity userSkillEntity = new UserSkillEntity();
		if (!userSkillRepository.existsById(id)) {
			return null;
		}
		userSkillEntity.setKnowledgeLevel(userSkillInserirVO.getKnowledgeLevel());
		userSkillEntity.setUpdated_at(userSkillInserirVO.getUpdated_at());
		userSkillEntity.setCreated_at(userSkillInserirVO.getCreated_at());
		userSkillEntity.setSkillEntity(userSkillInserirVO.getSkillEntity());
		userSkillEntity.setUserEntity(userSkillInserirVO.getUserEntity());
		
		userSkillEntity = userSkillRepository.save(userSkillEntity);
		
		return new UserSkillExibirVO(userSkillEntity);
	}
}
