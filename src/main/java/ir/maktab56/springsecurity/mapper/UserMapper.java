package ir.maktab56.springsecurity.mapper;

import ir.maktab56.springsecurity.domain.User;
import ir.maktab56.springsecurity.service.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User convertDTOtoEntity(UserDTO user);

    UserDTO convertEntityToDTO(User user);

    List<User> convertListDTOtoEntity(List<UserDTO> users);

    List<UserDTO> convertListEntityToDTO(List<User> user);
}
