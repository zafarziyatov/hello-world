package com.company.AdvensedLvlCRUD.repository;

import com.company.AdvensedLvlCRUD.modul.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer cardId);
}
