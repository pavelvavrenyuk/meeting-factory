package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.GroupDto;
import com.learning.meetingfactory.domain.mapper.GroupMapper;
import com.learning.meetingfactory.exception.EntityNotFoundException;
import com.learning.meetingfactory.exception.ErrorMessages;
import com.learning.meetingfactory.persistence.model.Group;
import com.learning.meetingfactory.persistence.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    CriterionService criterionService;

    @Override
    @Transactional(readOnly = true)
    public List<GroupDto> getAllGroups(Collection<String> includedAttributes) {
        List<GroupDto> groupDTOS = groupRepository.findAll()
                .stream()
                .map(group -> GroupMapper.INSTANCE.toGroupDto(group, includedAttributes))
                .collect(Collectors.toList());

        return groupDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public GroupDto findById(int id, Collection<String> includedAttributes) {

        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        ErrorMessages.GROUP_WITH_ID_DOES_NOT_EXIST, id)));

        return GroupMapper.INSTANCE.toGroupDto(group, includedAttributes);
    }

    @Override
    public GroupDto create(@Valid GroupDto groupDto) {

        Group group = GroupMapper.INSTANCE.toGroup(groupDto);
        group = groupRepository.save(group);

        return GroupMapper.INSTANCE.toGroupDto(group);
    }

    @Override
    public GroupDto update(@Valid GroupDto groupDto, int id) {
        return patch(groupDto, id);
    }

    @Override
    public GroupDto patch(GroupDto groupDto, int id) {

        GroupDto updatedGroup = groupRepository.findById(id)
                .map(group -> GroupMapper.INSTANCE.updateGroup(groupDto, group))
                .map(GroupMapper.INSTANCE::toGroupDto)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format(ErrorMessages.GROUP_WITH_ID_DOES_NOT_EXIST, id))
                );

        return updatedGroup;
    }

    @Override
    public void deleteById(int id) {
        if(!groupRepository.existsById(id)){
            throw new EntityNotFoundException(String.format(ErrorMessages.GROUP_WITH_ID_DOES_NOT_EXIST, id));
        }

        groupRepository.deleteById(id);
    }
}
