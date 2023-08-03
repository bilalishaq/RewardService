package com.work.rewardservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reward_id", referencedColumnName = "id")
    private Reward reward;

    @Column(name = "quanity")
    private long quantity;
    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date_creation")
    private Instant DateCreation;
    @Column(name = "date_update")
    private Instant DateUpate;
    @Column(name = "date_archived")
    private Instant DateArchived;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "archived")
    private Boolean archived;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_by")
    private Long updatedBy;
}
