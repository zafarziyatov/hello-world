package com.company.AdvensedLvlCRUD.cantroller;

import com.company.AdvensedLvlCRUD.dto.ResponseDto;
import com.company.AdvensedLvlCRUD.dto.requestDto.RequestCardDto;
import com.company.AdvensedLvlCRUD.dto.responseDto.ResponseCardDto;
import com.company.AdvensedLvlCRUD.service.CardService;
import com.company.AdvensedLvlCRUD.util.SimpleRequestCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.AdvensedLvlCRUD.config.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
public class CardController implements SimpleRequestCrud<Integer, RequestCardDto, ResponseCardDto> {

    private final CardService cardService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> created(@RequestBody RequestCardDto dto) {
        return convertStatusCodeByData(this.cardService.created(dto));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> get(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.cardService.get(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> update(@RequestParam(value = "id") Integer entityId, @RequestBody RequestCardDto dto) {
        return convertStatusCodeByData(this.cardService.update(entityId, dto));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<ResponseCardDto>> deleted(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.cardService.deleted(entityId));
    }
}
