import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ISurvey } from 'app/shared/model/survey.model';
import { Challenger } from 'app/shared/model/challenger.model';
import { Answer } from 'app/shared/model/answer.model';

@Component({
  selector: 'jhi-survey-answer-match',
  templateUrl: './survey-answer-match.component.html',
  styles: []
})
export class SurveyAnswerMatchComponent implements OnInit {

  survey: ISurvey;
  nbOfMatches: number;
  jugeId: string;
  // winners: Challenger[] = [];
  answers: Answer[] = [];
  challengerOne: Challenger;
  challengerTwo: Challenger;
  isAllMatchesCompleted: boolean = false;

  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ survey }) => {
      this.survey = survey;
    });

    this.nbOfMatches = this.survey.numberOfMatches;

    //TODO send requests to init images URLs

    this.initNextMatch();

    this.jugeId = '_' + Math.random().toString(36).substr(2, 9);
  }

  initNextMatch() {
    //TODO add random selection of images
    if (this.challengerOne && this.challengerOne.id == 'GOPR0111_2856-16') {
      this.challengerOne = new Challenger('GOPR0111_0853', '../../content/images/survey/GOPR0111_0853.png');
      this.challengerTwo = new Challenger('GOPR0111_2136', '../../content/images/survey/GOPR0111_2136.png');
    } else {
      this.challengerOne = new Challenger('GOPR0111_2856-16', '../../content/images/survey/GOPR0111_2856-16.png');
      this.challengerTwo = new Challenger('GOPR0111_3042', '../../content/images/survey/GOPR0111_3042.png');
    }
  }

  addWinner(winner) {
    console.log("Winner added: " + JSON.stringify(winner));
    // Add a new Answer from the winner
    this.answers.push(
      new Answer(undefined, this.jugeId, this.challengerOne.id, this.challengerTwo.id, winner.id, this.survey.id)
    );

    // Determine whether to display next challengers
    if(this.answers.length < this.nbOfMatches) {
      this.initNextMatch();
    } else {
      // if we've got enought winners, display socio-pro questions
      //TODO use Router to display next compo?
      console.log('Answers:');
      console.log(JSON.stringify(this.answers));
      this.isAllMatchesCompleted = true;
    }
  }

  getCurrentMatchNumber(): number {
    return this.answers.length + 1;
  }

  getPercentAdvancement(): number {
    return this.getCurrentMatchNumber() * 100 / this.nbOfMatches;
  }
}