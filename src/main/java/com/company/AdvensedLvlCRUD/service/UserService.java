package com.company.AdvensedLvlCRUD.service;

import com.company.AdvensedLvlCRUD.dto.ResponseDto;
import com.company.AdvensedLvlCRUD.dto.requestDto.RequestCardDto;
import com.company.AdvensedLvlCRUD.dto.requestDto.RequestUserDto;
import com.company.AdvensedLvlCRUD.dto.responseDto.ResponseUserDto;
import com.company.AdvensedLvlCRUD.repository.UserRepository;
import com.company.AdvensedLvlCRUD.service.mapper.UserMapper;
import com.company.AdvensedLvlCRUD.util.SimplerCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public ResponseDto<ResponseUserDto> created(RequestUserDto dto) {
        try {
            return ResponseDto.<ResponseUserDto>builder()
                    .success(true)
                    .message("OK")
                    .contend(this.userMapper.toDto(this.userRepository.save(this.userMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseUserDto>builder()
                    .code(-2)
                    .message(String.format("User while saving error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<ResponseUserDto> get(Integer entityId) {
        return this.userRepository.findByUserIdAndDeletedAtIsNull(entityId)
                .map(user -> ResponseDto.<ResponseUserDto>builder()
                        .success(true)
                        .message("OK")
                        .contend(this.userMapper.toDto(user))
                        .build())
                .orElse(ResponseDto.<ResponseUserDto>builder()
                        .message(String.format("User with %d:id is not found", entityId))
                        .contend(null)
                        .build());


    }

    public ResponseDto<ResponseUserDto> update(Integer entityId, RequestUserDto dto) {
        try {
            return this.userRepository.findByUserIdAndDeletedAtIsNull(entityId)
                    .map(user -> ResponseDto.<ResponseUserDto>builder()
                            .success(true)
                            .message("OK")
                            .contend(this.userMapper.toDto(this.userRepository.save(this.userMapper.updateUser(dto, user))))
                            .build()
                    )
                    .orElse(ResponseDto.<ResponseUserDto>builder()
                            .message(String.format("User with %d:id is not found", entityId))
                            .build());

        } catch (Exception e) {
            return ResponseDto.<ResponseUserDto>builder()
                    .code(-2)
                    .message(String.format("User while updating error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<ResponseUserDto> deleted(Integer entityId) {
        try {
            return this.userRepository.findByUserIdAndDeletedAtIsNull(entityId)
                    .map(user -> {
                        user.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseUserDto>builder()
                                .success(true)
                                .message("OK")
                                .contend(this.userMapper.toDto(this.userRepository.save(user)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseUserDto>builder()
                            .message(String.format("User with %d:id is not found", entityId))
                            .build());

        } catch (Exception e) {
            return ResponseDto.<ResponseUserDto>builder()
                    .code(-2)
                    .message(String.format("User while deleting error! Message :: %s", e.getMessage()))
                    .build();
        }
    }


}
