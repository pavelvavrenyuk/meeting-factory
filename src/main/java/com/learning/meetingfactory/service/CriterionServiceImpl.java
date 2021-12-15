package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.CriterionDto;
import com.learning.meetingfactory.domain.mapper.CriterionMapper;
import com.learning.meetingfactory.exception.EntityNotFoundException;
import com.learning.meetingfactory.exception.ErrorMessages;
import com.learning.meetingfactory.persistence.model.Criterion;
import com.learning.meetingfactory.persistence.model.Group;
import com.learning.meetingfactory.persistence.repository.CriterionRepository;
import com.learning.meetingfactory.persistence.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CriterionServiceImpl implements CriterionService {

    @Autowired
    CriterionRepository criterionRepository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CriterionDto> getCriteriaForGroup(int groupId) {

        List<CriterionDto> criterionDTOS = criterionRepository.findByGroup_Id(groupId)
                .stream()
                .map(CriterionMapper.INSTANCE::toCriterionDto)
                .collect(Collectors.toList());

        return criterionDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public CriterionDto findById(int id) {

        Criterion criterion = criterionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        ErrorMessages.CRITERION_WITH_ID_DOES_NOT_EXIST, id)));

        return CriterionMapper.INSTANCE.toCriterionDto(criterion);
    }

    @Override
    public CriterionDto create(@Valid CriterionDto criterionDto) {

        int groupId = criterionDto.getGroupId();

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(ErrorMessages.GROUP_WITH_ID_DOES_NOT_EXIST, groupId)));

        Criterion criterion = CriterionMapper.INSTANCE.toCriterion(criterionDto);
        criterion.setGroup(group);

        criterion = criterionRepository.save(criterion);

        return CriterionMapper.INSTANCE.toCriterionDto(criterion);
    }

    @Override
    public CriterionDto update(@Valid CriterionDto criterionDto, int id) {
        return patch(criterionDto, id);
    }

    @Override
    public CriterionDto patch(CriterionDto criterionDto, int id) {

        CriterionDto updatedCriterionDto = criterionRepository.findById(id)
                .map(criterion -> CriterionMapper.INSTANCE.updateCriterion(criterionDto, criterion))
                .map(CriterionMapper.INSTANCE::toCriterionDto)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format(ErrorMessages.CRITERION_WITH_ID_DOES_NOT_EXIST, id))
                );

        return updatedCriterionDto;
    }

    @Override
    public void deleteById(int id) {
        if(!criterionRepository.existsById(id)){
            throw new EntityNotFoundException(String.format(ErrorMessages.CRITERION_WITH_ID_DOES_NOT_EXIST, id));
        }

        criterionRepository.deleteById(id);
    }
}
