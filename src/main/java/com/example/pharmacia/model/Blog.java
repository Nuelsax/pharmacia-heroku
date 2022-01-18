package com.example.pharmacia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "blog")
public class Blog {
    @Id
    @SequenceGenerator(
            name = "blog_sequence",
            sequenceName = "blog_sequence",
            allocationSize = 1

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_sequence"
    )
    private Long id;
    private String blogTitle;
    private String shortDesc;
    private String blogPost;
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "poster_id",
            referencedColumnName = "id"
    )
    private User user;
}
