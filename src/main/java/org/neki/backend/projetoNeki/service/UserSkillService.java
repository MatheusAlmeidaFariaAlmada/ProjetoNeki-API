package org.neki.backend.projetoNeki.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	// Listar todos
	public List<UserSkillExibirVO> buscarTodosService() {
		List<UserSkillExibirVO> userSkillExibirVO = new ArrayList<UserSkillExibirVO>();
		List<UserSkillEntity> userSkillEntity = userSkillRepository.findAll();
		
		for (UserSkillEntity userSkillEntity1 : userSkillEntity) {
			UserSkillExibirVO userSkillVO = new UserSkillExibirVO(userSkillEntity1);
			userSkillExibirVO.add(userSkillVO);
		}
		return userSkillExibirVO;
	}
	
	// Esse serviço deve receber o id do usuário e retornar todas as skills associadas a ele
	public UserSkillExibirVO listarPorIdService(Long id) {
		Optional<UserSkillEntity> userSkillEntity = userSkillRepository.findById(id);
		if (!userSkillEntity.isPresent()) {
			return null;
		}
		return new UserSkillExibirVO(userSkillEntity.get());
	}
	
	// Esse serviço deve receber o id da associação da skill e o level para atualização na base de dados
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
	
	// Esse serviço deve receber o id da associação da skill e excluir da base de dados
	
}
