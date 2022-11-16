package com.cf.cabinescaperoom.service;

import com.cf.cabinescaperoom.models.ScoreForm;
import com.cf.cabinescaperoom.repositories.ScoreFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScoreFormService {

    @Autowired
    ScoreFormRepository repo;

    public ScoreForm addScoreForm(ScoreForm formData) {

        int stars;

        if (formData.getMinutes() < 60) {
            stars = lessThanSixty(formData);
            formData.setStars(stars);
        } else if (formData.getMinutes() < 90){
            stars = lessThanNinety(formData);
            formData.setStars(stars);
        } else if (formData.getMinutes() < 120){
            stars = lessThanOneTwenty(formData);
            formData.setStars(stars);
        } else if (formData.getMinutes() > 120){
            stars = greaterThanOneTwenty(formData);
            formData.setStars(stars);
        }
        return repo.save(formData);
    }

    public void editScoreForm(ScoreForm scoreForm) {
        ScoreForm update = repo.findById(scoreForm.getId()).orElse(null);
        int stars;

        if (scoreForm.getMinutes() < 60) {
            stars = lessThanSixty(scoreForm);
            scoreForm.setStars(stars);
        } else if (scoreForm.getMinutes() < 90){
            stars = lessThanNinety(scoreForm);
            scoreForm.setStars(stars);
        } else if (scoreForm.getMinutes() < 120){
            stars = lessThanOneTwenty(scoreForm);
            scoreForm.setStars(stars);
        } else if (scoreForm.getMinutes() > 120){
            stars = greaterThanOneTwenty(scoreForm);
            scoreForm.setStars(stars);
        }

        if (update != null) {
            update.setName1(scoreForm.getName1());
            update.setName2(scoreForm.getName2());
            update.setName2(scoreForm.getName3());
            update.setName2(scoreForm.getName4());
            update.setName2(scoreForm.getName5());
            update.setName2(scoreForm.getName6());
            update.setActivity_name(scoreForm.getActivity_name());
            update.setCompletion_date(scoreForm.getCompletion_date());
            update.setMinutes(scoreForm.getMinutes());
            update.setHelp_cards(scoreForm.getHelp_cards());
            update.setStars(scoreForm.getStars());
            repo.save(update);
        } else {
            repo.save(scoreForm);
        }

    }

    public void deleteScoreForm(long id){
        repo.findById(id).ifPresent(toDelete -> repo.delete(toDelete));
    }

    public ScoreForm getById(long scoreFormId) {
        return repo.findById(scoreFormId).orElse(null);
    }

    public List<ScoreForm> getAll() {
        return (List<ScoreForm>) repo.findAll();
    }

    private int greaterThanOneTwenty(ScoreForm formData) {
        int stars = 0;

        if(formData.getMinutes() > 120 && formData.getHelp_cards() == 0)
            stars = 7;
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 1)
            stars = 5;
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 2)
            stars = 4;
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 3)
            stars = 2;
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 4)
            stars = 1;
        return stars;
    }

    private int lessThanOneTwenty(ScoreForm formData) {
        int stars = 0;
        if(formData.getMinutes() < 120 && formData.getHelp_cards() == 0)
            stars = 8;
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 1)
            stars = 6;
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 2)
            stars = 5;
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 3)
            stars = 3;
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 4)
            stars = 2;
        return stars;
    }

    private int lessThanNinety(ScoreForm formData) {
        int stars = 0;
        if(formData.getMinutes() < 90 && formData.getHelp_cards() == 0)
            stars = 9;
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 1)
            stars = 7;
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 2)
            stars = 6;
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 3)
            stars = 4;
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 4)
            stars = 3;
        return stars;
    }

    private int lessThanSixty(ScoreForm formData) {
        int stars = 0;
        if(formData.getMinutes() < 60 && formData.getHelp_cards() == 0)
            stars = 10;
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 1)
            stars = 8;
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 2)
            stars = 7;
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 3)
            stars = 5;
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 4)
            stars = 4;
        return stars;
    }
}
