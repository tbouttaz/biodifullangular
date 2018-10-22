package org.biodifull.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Answer.
 */
@Entity
@Table(name = "answer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "juge_id", nullable = false)
    private String jugeID;

    @NotNull
    @Column(name = "challenger_1", nullable = false)
    private String challenger1;

    @NotNull
    @Column(name = "challenger_2", nullable = false)
    private String challenger2;

    @NotNull
    @Column(name = "winner", nullable = false)
    private String winner;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Survey survey;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJugeID() {
        return jugeID;
    }

    public Answer jugeID(String jugeID) {
        this.jugeID = jugeID;
        return this;
    }

    public void setJugeID(String jugeID) {
        this.jugeID = jugeID;
    }

    public String getChallenger1() {
        return challenger1;
    }

    public Answer challenger1(String challenger1) {
        this.challenger1 = challenger1;
        return this;
    }

    public void setChallenger1(String challenger1) {
        this.challenger1 = challenger1;
    }

    public String getChallenger2() {
        return challenger2;
    }

    public Answer challenger2(String challenger2) {
        this.challenger2 = challenger2;
        return this;
    }

    public void setChallenger2(String challenger2) {
        this.challenger2 = challenger2;
    }

    public String getWinner() {
        return winner;
    }

    public Answer winner(String winner) {
        this.winner = winner;
        return this;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Survey getSurvey() {
        return survey;
    }

    public Answer survey(Survey survey) {
        this.survey = survey;
        return this;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
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
        Answer answer = (Answer) o;
        if (answer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), answer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Answer{" +
            "id=" + getId() +
            ", jugeID='" + getJugeID() + "'" +
            ", challenger1='" + getChallenger1() + "'" +
            ", challenger2='" + getChallenger2() + "'" +
            ", winner='" + getWinner() + "'" +
            "}";
    }
}
