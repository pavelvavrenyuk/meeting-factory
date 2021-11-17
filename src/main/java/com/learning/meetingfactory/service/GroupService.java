package com.learning.meetingfactory.service;

import com.learning.meetingfactory.domain.dto.GroupDto;

import java.util.Collection;
import java.util.List;

public interface GroupService {

    List<GroupDto> getAllGroups(Collection<String> includedAttributes);

    GroupDto findById(int id, Collection<String> includedAttributes);

    GroupDto create(GroupDto groupDto);

    GroupDto update(GroupDto groupDto, int id);

    GroupDto patch(GroupDto groupDto, int id);

    void deleteById(int id);


}
