export interface ISurvey {
    id?: number;
    surveyName?: string;
    surveyDescription?: string;
    surveyURL?: string;
    formURL?: string;
    challengersLocation?: string;
    numberOfMatches?: number;
    open?: boolean;
}

export class Survey implements ISurvey {
    constructor(
        public id?: number,
        public surveyName?: string,
        public surveyDescription?: string,
        public surveyURL?: string,
        public formURL?: string,
        public challengersLocation?: string,
        public numberOfMatches?: number,
        public open?: boolean
    ) {
        this.open = this.open || false;
    }
}
