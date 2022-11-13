package com.cf.cabinescaperoom.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "score_form")
@Getter
@Setter
@EqualsAndHashCode
public class ScoreForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_one")
    private String name1;
    @Column(name = "name_two")
    private String name2;
    @Column(name = "name_three")
    private String name3;
    @Column(name = "name_four")
    private String name4;
    @Column(name = "name_five")
    private String name5;
    @Column(name = "name_six")
    private String name6;

    @Column(name = "activity_name")
    private String activity_name;

    @Column(name = "completion_date")
    private LocalDate date;

    @Column(name = "completion_time")
    private int minutes;

    @Column(name = "help_cards")
    private int help_cards;

    @Column(name = "stars")
    private int stars;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
