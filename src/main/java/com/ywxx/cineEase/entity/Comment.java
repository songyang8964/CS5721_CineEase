package com.ywxx.cineEase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    private Long commentId;
    private String content;
    private String posterName;
    private BigDecimal rate;
    private Long movieId;
    private Date creatOn;


}
