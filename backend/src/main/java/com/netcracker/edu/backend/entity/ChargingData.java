package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions", schema = "chargemedb", catalog = "")
public class ChargingData {

    private Long id;

    private LocalDateTime startDate;

    private Customer customerId;
    private CService serviceId;
    private Wallet walletId;

    private boolean isBlocked = false;

    public ChargingData() {}

    public ChargingData(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    @Basic
    @Column(name = "startDate")
    public LocalDateTime getStartDate() {return startDate; }

    public void setStartDate(LocalDateTime startDate) {this.startDate = startDate; }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomerId() {return customerId;}

    public void setCustomerId(Customer customerId) {this.customerId = customerId;}

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    public CService getServiceId() {return serviceId;}

    public void setServiceId(CService serviceId) {this.serviceId = serviceId;}

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    public Wallet getWalletId() {return walletId;}

    public void setWalletId(Wallet walletId) {this.walletId = walletId;}

    @Basic
    @Column(name = "is_blocked")
    public boolean isBlocked() { return isBlocked; }

    public void setBlocked(boolean blocked) { isBlocked = blocked; }
}
