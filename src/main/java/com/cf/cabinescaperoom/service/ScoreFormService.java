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

        ScoreForm toReturn = new ScoreForm();

        if (formData.getMinutes() < 60) {
            toReturn = lessThanSixty(formData);
        } else if (formData.getMinutes() < 90){
            toReturn = lessThanNinety(formData);
        } else if (formData.getMinutes() < 120){
            toReturn = lessThanOneTwenty(formData);
        } else if (formData.getMinutes() > 120){
            toReturn = greaterThanOneTwenty(formData);
        }

        if(toReturn != null){
            return repo.save(toReturn);
        }else {
            return repo.save(formData);
        }

    }

    private ScoreForm greaterThanOneTwenty(ScoreForm formData) {
        if(formData.getMinutes() > 120 && formData.getHelp_cards() == 0)
            formData.setStars(7);
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 1)
            formData.setStars(5);
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 2)
            formData.setStars(4);
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 3)
            formData.setStars(2);
        else if (formData.getMinutes() > 120 && formData.getHelp_cards() == 4)
            formData.setStars(1);

        return formData;
    }

    private ScoreForm lessThanOneTwenty(ScoreForm formData) {
        if(formData.getMinutes() < 120 && formData.getHelp_cards() == 0)
            formData.setStars(8);
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 1)
            formData.setStars(6);
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 2)
            formData.setStars(5);
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 3)
            formData.setStars(3);
        else if (formData.getMinutes() < 120 && formData.getHelp_cards() == 4)
            formData.setStars(2);

        return formData;
    }

    private ScoreForm lessThanNinety(ScoreForm formData) {
        if(formData.getMinutes() < 90 && formData.getHelp_cards() == 0)
            formData.setStars(9);
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 1)
            formData.setStars(7);
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 2)
            formData.setStars(6);
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 3)
            formData.setStars(4);
        else if (formData.getMinutes() < 90 && formData.getHelp_cards() == 4)
            formData.setStars(3);

        return formData;
    }

    private ScoreForm lessThanSixty(ScoreForm formData) {
        if(formData.getMinutes() < 60 && formData.getHelp_cards() == 0)
            formData.setStars(10);
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 1)
            formData.setStars(8);
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 2)
            formData.setStars(7);
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 3)
            formData.setStars(5);
        else if (formData.getMinutes() < 60 && formData.getHelp_cards() == 4)
            formData.setStars(4);

        return formData;
    }

    public ScoreForm getById(long scoreFormId) {
        return repo.findById(scoreFormId).orElse(null);
    }

    public List<ScoreForm> getAll() {
        return (List<ScoreForm>) repo.findAll();
    }
}
