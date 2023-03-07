package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id) {
        Answer answer = answerRepository.findById(id).orElseThrow();
        return answer;
    }

    public void modify(Answer answer,String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        answerRepository.save(answer);
    }
}
