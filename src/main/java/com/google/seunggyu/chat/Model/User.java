package com.google.seunggyu.chat.Model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class User {

    @Id
    private String id;

    @Column(length = 30)
    private String name;
}
