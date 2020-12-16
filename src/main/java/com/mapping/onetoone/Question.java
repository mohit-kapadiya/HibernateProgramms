package com.mapping.onetoone;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    private int id;
    private String question;
    @OneToOne
    private Answer answer;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
