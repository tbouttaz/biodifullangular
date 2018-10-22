package org.biodifull.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Survey entity.
 */
public class SurveyDTO implements Serializable {

    private Long id;

    @NotNull
    private String surveyName;

    @NotNull
    private String surveyDescription;

    @NotNull
    private String surveyURL;

    @NotNull
    private String formURL;

    @NotNull
    private String challengersLocation;

    @NotNull
    private Integer numberOfMatches;

    @NotNull
    private Boolean open;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    public void setSurveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }

    public String getSurveyURL() {
        return surveyURL;
    }

    public void setSurveyURL(String surveyURL) {
        this.surveyURL = surveyURL;
    }

    public String getFormURL() {
        return formURL;
    }

    public void setFormURL(String formURL) {
        this.formURL = formURL;
    }

    public String getChallengersLocation() {
        return challengersLocation;
    }

    public void setChallengersLocation(String challengersLocation) {
        this.challengersLocation = challengersLocation;
    }

    public Integer getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(Integer numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SurveyDTO surveyDTO = (SurveyDTO) o;
        if (surveyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), surveyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SurveyDTO{" +
            "id=" + getId() +
            ", surveyName='" + getSurveyName() + "'" +
            ", surveyDescription='" + getSurveyDescription() + "'" +
            ", surveyURL='" + getSurveyURL() + "'" +
            ", formURL='" + getFormURL() + "'" +
            ", challengersLocation='" + getChallengersLocation() + "'" +
            ", numberOfMatches=" + getNumberOfMatches() +
            ", open='" + isOpen() + "'" +
            "}";
    }
}
