import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Challenger } from 'app/shared/model/challenger.model';

@Component({
  selector: 'jhi-survey-individual-match',
  templateUrl: './survey-individual-match.component.html',
  styles: []
})
export class SurveyIndividualMatchComponent implements OnInit {

  @Input() challengerOne: Challenger;
  @Input() challengerTwo: Challenger;
  @Output() winnerSelected = new EventEmitter<Challenger>();

  constructor() { }

  ngOnInit() {
  }

  challengerClicked(challenger) {
    //TODO add start and end date to challenges 
    this.winnerSelected.emit(challenger);
  }
}
