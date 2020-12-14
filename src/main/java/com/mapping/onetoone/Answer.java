package com.mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
    @Id
    private int id;
    private String answer;
    @OneToOne(mappedBy = "answer")
    private Question question;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
