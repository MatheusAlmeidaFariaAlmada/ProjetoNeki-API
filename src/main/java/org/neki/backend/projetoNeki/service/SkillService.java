package org.neki.backend.projetoNeki.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.neki.backend.projetoNeki.entity.SkillEntity;
import org.neki.backend.projetoNeki.entity.UserSkillEntity;
import org.neki.backend.projetoNeki.repository.SkillRepository;
import org.neki.backend.projetoNeki.vo.SkillExibirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
	// Listar todos
	public List<SkillExibirVO> buscarTodosService() {
		List<SkillExibirVO> skillExibirVO = new ArrayList<SkillExibirVO>();
		List<SkillEntity> skillEntity = skillRepository.findAll();
		
		for (SkillEntity skillEntity1 : skillEntity) {
			SkillExibirVO skillVO = new SkillExibirVO(skillEntity1);
			skillExibirVO.add(skillVO);
		}
		return skillExibirVO;
	}
	
	// Listar por ID
	public SkillExibirVO listarPorIdService(Long id) {
		Optional<SkillEntity> skillEntity = skillRepository.findById(id);
		if (!skillEntity.isPresent()) {
			return null;
		}
		return new SkillExibirVO(skillEntity.get());
	}
	
	// Deletar
	public boolean deletarService(Long id) {
		if (!skillRepository.existsById(id)) {
			return false;
		}
		skillRepository.deleteById(id);
		return true;
	}
}
