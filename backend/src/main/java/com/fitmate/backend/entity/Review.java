package com.fitmate.backend.entity;

import com.fitmate.backend.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long id;
    private String content;
    private Integer rating;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "portfolio")
    private Portfolio portfolio;
    @ManyToOne
    @JoinColumn(name = "writer")
    private Member member;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }
    public Review(Review review){
        id = review.getId();
        content = review.getContent();
        rating = review.getRating();
        createdAt = review.getCreatedAt();
        portfolio = review.getPortfolio();
        member = review.getMember();
    }
    public Review updateReview(ReviewDto reviewDto){
        return this;
    }
}
