package com.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer1 {
    @Id
    private int id;
    private String answer;
    @ManyToOne
    private Question1 question1;

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion1(Question1 question1) {
        this.question1 = question1;
    }
}
