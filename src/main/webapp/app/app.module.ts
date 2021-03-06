import './vendor.ts';

import { NgModule, Injector } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { Ng2Webstorage, LocalStorageService, SessionStorageService } from 'ngx-webstorage';
import { JhiEventManager } from 'ng-jhipster';

import { AuthInterceptor } from './blocks/interceptor/auth.interceptor';
import { AuthExpiredInterceptor } from './blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from './blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from './blocks/interceptor/notification.interceptor';
import { BiodifullangularSharedModule } from 'app/shared';
import { BiodifullangularCoreModule } from 'app/core';
import { BiodifullangularAppRoutingModule } from './app-routing.module';
import { BiodifullangularHomeModule } from './home/home.module';
import { BiodifullangularAccountModule } from './account/account.module';
import { BiodifullangularEntityModule } from './entities/entity.module';
import * as moment from 'moment';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent, NavbarComponent, FooterComponent, PageRibbonComponent, ActiveMenuDirective, ErrorComponent } from './layouts';
import { SurveyAnswerComponentComponent } from './survey-answer-component/survey-answer-component.component';
import { SurveyAnswerMatchComponent } from './survey-answer-match/survey-answer-match.component';
import { SurveyIndividualMatchComponent } from './survey-individual-match/survey-individual-match.component';

@NgModule({
    imports: [
        BrowserModule,
        BiodifullangularAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-' }),
        BiodifullangularSharedModule,
        BiodifullangularCoreModule,
        BiodifullangularHomeModule,
        BiodifullangularAccountModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
        BiodifullangularEntityModule
    ],
    declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent, SurveyAnswerComponentComponent, SurveyAnswerMatchComponent, SurveyIndividualMatchComponent],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthInterceptor,
            multi: true,
            deps: [LocalStorageService, SessionStorageService]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true,
            deps: [Injector]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true,
            deps: [JhiEventManager]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true,
            deps: [Injector]
        }
    ],
    bootstrap: [JhiMainComponent]
})
export class BiodifullangularAppModule {
    constructor(private dpConfig: NgbDatepickerConfig) {
        this.dpConfig.minDate = { year: moment().year() - 100, month: 1, day: 1 };
    }
}
