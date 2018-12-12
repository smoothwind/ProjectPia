import { Time } from '@angular/common';
export class PiaUser {
    constructor(private idUser?: number,
        public userName?: string,
        private password?: string,
        private gender?: Number,
        private eMail?: string,
        private address?: string,
        private bio?: string,
        private updateTime?: Time) {}
}
