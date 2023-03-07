package com.mysite.sbb.user;


import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
@Getter
@Setter
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

//    @OneToMany(mappedBy = "author")
//    private List<Question> questions;
//
//    @OneToMany(mappedBy = "author")
//    private List<Answer> answers;
}
