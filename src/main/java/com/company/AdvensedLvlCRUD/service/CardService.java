package com.company.AdvensedLvlCRUD.service;

import com.company.AdvensedLvlCRUD.dto.ResponseDto;
import com.company.AdvensedLvlCRUD.dto.requestDto.RequestCardDto;
import com.company.AdvensedLvlCRUD.dto.responseDto.ResponseCardDto;
import com.company.AdvensedLvlCRUD.repository.CardRepository;
import com.company.AdvensedLvlCRUD.service.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    public ResponseDto<ResponseCardDto> created(RequestCardDto dto) {
        try {
            return ResponseDto.<ResponseCardDto>builder()
                    .success(true)
                    .message("OK")
                    .contend(this.cardMapper.toDo(this.cardRepository.save(this.cardMapper.toEntity(dto))))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<ResponseCardDto>builder()
                    .code(-2)
                    .message(String.format("Card while saving error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<ResponseCardDto> get(Integer entityId) {
        return this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId)
                .map(card -> ResponseDto.<ResponseCardDto>builder()
                        .success(true)
                        .message("OK")
                        .contend(this.cardMapper.toDo(card))
                        .build())
                .orElse(ResponseDto.<ResponseCardDto>builder()
                        .message(String.format("Card with %d  :: id is not found", entityId))
                        .build());

    }

    public ResponseDto<ResponseCardDto> update(Integer entityId, RequestCardDto dto) {
        try {

            return this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId)
                    .map(card -> ResponseDto.<ResponseCardDto>builder()
                            .success(true)
                            .message("OK")
                            .contend(this.cardMapper.toDo(this.cardRepository.save(this.cardMapper.updateCard(dto, card))))
                            .build())
                    .orElse(ResponseDto.<ResponseCardDto>builder()
                            .message(String.format("Card with %d  :: id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseCardDto>builder()
                    .code(-2)
                    .message(String.format("Card while updating error! Message :: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<ResponseCardDto> deleted(Integer entityId) {
        try {
            return this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId)
                    .map(card -> {
                        card.setDeletedAt(LocalDateTime.now());
                        return ResponseDto.<ResponseCardDto>builder()
                                .success(true)
                                .message("OK")
                                .contend(this.cardMapper.toDo(this.cardRepository.save(card)))
                                .build();
                    })
                    .orElse(ResponseDto.<ResponseCardDto>builder()
                            .message(String.format("Card with %d  :: id is not found", entityId))
                            .build());
        } catch (Exception e) {
            return ResponseDto.<ResponseCardDto>builder()
                    .code(-2)
                    .message(String.format("Card while deleting error! Message :: %s", e.getMessage()))
                    .build();
        }
    }


}
