package com.deloitte.deloitter.mapstruct.mapper;

import com.deloitte.deloitter.dwitt.entity.Dwitt;
import com.deloitte.deloitter.mapstruct.dtos.DwittDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetDto;
import com.deloitte.deloitter.mapstruct.dtos.UserPostDto;
import com.deloitte.deloitter.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    UserGetDto userToUserDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);

    DwittDto dwittToDwittDto(Dwitt dwitt);

    List<DwittDto> dwittsToDwittDtoList(List<Dwitt> dwitts);
}
