export interface IAnswer {
    id?: number;
    jugeID?: string;
    challenger1?: string;
    challenger2?: string;
    winner?: string;
    surveyId?: number;
}

export class Answer implements IAnswer {
    constructor(
        public id?: number,
        public jugeID?: string,
        public challenger1?: string,
        public challenger2?: string,
        public winner?: string,
        public surveyId?: number
    ) {}
}
