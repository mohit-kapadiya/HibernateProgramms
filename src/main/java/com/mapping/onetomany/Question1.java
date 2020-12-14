package com.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Question1 {
    @Id
    private int id;
    private String question;
    @OneToMany
    private List<Answer1> answer1List;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1List(List<Answer1> answer1List) {
        this.answer1List = answer1List;
    }

}
