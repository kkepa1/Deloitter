package com.deloitte.deloitter.mapstruct.mapper;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.mapstruct.dtos.*;
import com.deloitte.deloitter.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    UserGetDto userToUserDto(User user);

    UserGetAllDto userToUserAllDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);

    UserDeleteDto userToUserDeleteDto(UserDeleteDto userDeleteDto);

    DwittDto dwittToDwittDto(Dwitt dwitt);

    List<DwittDto> dwittsToDwittDtoList(List<Dwitt> dwitts);
}
