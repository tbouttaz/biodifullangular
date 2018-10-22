package org.biodifull.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Survey.
 */
@Entity
@Table(name = "survey")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "survey_name", nullable = false)
    private String surveyName;

    @NotNull
    @Column(name = "survey_description", nullable = false)
    private String surveyDescription;

    @NotNull
    @Column(name = "survey_url", nullable = false)
    private String surveyURL;

    @NotNull
    @Column(name = "form_url", nullable = false)
    private String formURL;

    @NotNull
    @Column(name = "challengers_location", nullable = false)
    private String challengersLocation;

    @NotNull
    @Column(name = "number_of_matches", nullable = false)
    private Integer numberOfMatches;

    @NotNull
    @Column(name = "jhi_open", nullable = false)
    private Boolean open;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public Survey surveyName(String surveyName) {
        this.surveyName = surveyName;
        return this;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    public Survey surveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
        return this;
    }

    public void setSurveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }

    public String getSurveyURL() {
        return surveyURL;
    }

    public Survey surveyURL(String surveyURL) {
        this.surveyURL = surveyURL;
        return this;
    }

    public void setSurveyURL(String surveyURL) {
        this.surveyURL = surveyURL;
    }

    public String getFormURL() {
        return formURL;
    }

    public Survey formURL(String formURL) {
        this.formURL = formURL;
        return this;
    }

    public void setFormURL(String formURL) {
        this.formURL = formURL;
    }

    public String getChallengersLocation() {
        return challengersLocation;
    }

    public Survey challengersLocation(String challengersLocation) {
        this.challengersLocation = challengersLocation;
        return this;
    }

    public void setChallengersLocation(String challengersLocation) {
        this.challengersLocation = challengersLocation;
    }

    public Integer getNumberOfMatches() {
        return numberOfMatches;
    }

    public Survey numberOfMatches(Integer numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
        return this;
    }

    public void setNumberOfMatches(Integer numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public Boolean isOpen() {
        return open;
    }

    public Survey open(Boolean open) {
        this.open = open;
        return this;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Survey survey = (Survey) o;
        if (survey.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), survey.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Survey{" +
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
