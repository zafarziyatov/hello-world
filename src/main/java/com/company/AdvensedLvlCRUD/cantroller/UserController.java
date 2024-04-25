package com.company.AdvensedLvlCRUD.cantroller;

import com.company.AdvensedLvlCRUD.dto.ResponseDto;
import com.company.AdvensedLvlCRUD.dto.requestDto.RequestUserDto;
import com.company.AdvensedLvlCRUD.dto.responseDto.ResponseUserDto;
import com.company.AdvensedLvlCRUD.service.UserService;
import com.company.AdvensedLvlCRUD.util.SimpleRequestCrud;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.AdvensedLvlCRUD.config.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
public class UserController implements SimpleRequestCrud<Integer, RequestUserDto, ResponseUserDto> {
    private final UserService userService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> created(@RequestBody RequestUserDto dto) {
        return convertStatusCodeByData(this.userService.created(dto));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> get(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.get(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> update(@RequestParam(value = "id") Integer entityId,@RequestBody RequestUserDto dto) {
        return convertStatusCodeByData(this.userService.update(entityId,dto));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseUserDto>> deleted(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.deleted(entityId));
    }
}
