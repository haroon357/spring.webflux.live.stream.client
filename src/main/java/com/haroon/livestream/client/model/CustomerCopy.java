package com.haroon.livestream.client.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "customer_copy")
@Table(name = "customer_copy")
public class CustomerCopy {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
