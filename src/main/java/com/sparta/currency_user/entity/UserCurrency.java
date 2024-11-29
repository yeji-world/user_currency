package com.sparta.currency_user.entity;

import com.sparta.currency_user.status.Status;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user_currency")
public class UserCurrency extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "to_currency_id", nullable = false)
    private Currency currency;

    @Column(name = "amount_in_krw", nullable = false)
    private BigDecimal beforeAmount;

    @Column(name = "amount_after_exchange", nullable = false)
    private BigDecimal afterAmount;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public UserCurrency(User user, Currency currency, BigDecimal beforeAmount, BigDecimal afterAmount, Status status) {
        this.user = user;
        this.currency = currency;
        this.beforeAmount = beforeAmount;
        this.afterAmount = afterAmount;
        this.status = status;
    }

    public UserCurrency() {
    }

    public void cancelExchange(Status status) {
        this.status = status;
    }
}
