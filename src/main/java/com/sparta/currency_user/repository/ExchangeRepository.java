package com.sparta.currency_user.repository;

import com.sparta.currency_user.dto.TotalExchageResponseDto;
import com.sparta.currency_user.entity.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<UserCurrency, Long> {

    List<UserCurrency> findAllByUserId(Long id);

    default UserCurrency findByIdOrElseThrows(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "환전 정보가 존재하지 않습니다."));
    }

    //쿼리 결과로 얻은 값(count, sum)들을 TotalExchangesResponseDto 생성자로 전달하여 dto 객체 생성
    @Query("SELECT new com.sparta.currency_user.dto.TotalExchageResponseDto(COUNT(uc), SUM(uc.beforeAmount)) FROM UserCurrency uc WHERE uc.user.id = :userId GROUP BY uc.user.id")
    TotalExchageResponseDto findTotalExchangeByUserId(Long userId);
}
