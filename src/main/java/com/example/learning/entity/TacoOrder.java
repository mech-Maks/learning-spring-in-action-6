package com.example.learning.entity;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @ManyToOne
    private User user;

    @Column(name = "delivery_name")
    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @Column(name = "delivery_street")
    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @Column(name = "delivery_city")
    @NotBlank(message="City is required")
    private String deliveryCity;

    @Column(name = "delivery_state")
    @NotBlank(message="State is required")
    private String deliveryState;

    @Column(name = "delivery_zip")
    @NotBlank(message="Zip code is required")
    private String deliveryZip;

    @Column(name = "cc_number")
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Column(name = "cc_expiration")
    @Pattern(regexp="^(0[1-9]|1[0-2])(\\/)([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Column(name = "cc_cvv")
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
