package com.example.UberReviewService.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EntityListeners(AuditingEntityListener.class) // -> Now shifted to BaseModel class
@Entity
@Table(name = "BookingReview") // Here we can give a custom name to our table, although we also have 'name' property for
                        // @Entity but that will affect the entire java logic whereas @Table will only affect the database
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{
    @Column(nullable = false) // To set 'content' column as not null
    private String content;

    private Double rating;

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " " + this.createdAt;
    }

}
