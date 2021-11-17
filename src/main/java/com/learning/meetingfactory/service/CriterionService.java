package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.CriterionDto;
import com.learning.meetingfactory.persistence.model.Criterion;

import java.util.List;

public interface CriterionService {

    List<CriterionDto> getCriteriaForGroup(int groupId);

    CriterionDto findById(int id);

    CriterionDto create(CriterionDto criterionDto);

    CriterionDto update(CriterionDto criterionDto, int id);

    CriterionDto patch(CriterionDto criterionDto, int id);

    void deleteById(int id);
}
