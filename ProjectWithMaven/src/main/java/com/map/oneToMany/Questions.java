package com.map.oneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questions {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	
	private String Question;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Answers> answers;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}


	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}


	public Questions(int questionId, String question, List<Answers> answers) {
		super();
		this.questionId = questionId;
		Question = question;
		this.answers = answers;
	}


	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
