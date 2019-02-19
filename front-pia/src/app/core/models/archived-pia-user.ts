import { Time } from '@angular/common';

export class ArchivedPiaUser {
    constructor(private idUser?: number,
        private userName?: string,
        private password?: string,
        private gender?: number,
        private eMail?: string,
        private address?: string,
        private bio?: string,
        private updateTime?: Time,
        private archiveTime?: Time,
        private archiveReason?: number
        ) {}
}
