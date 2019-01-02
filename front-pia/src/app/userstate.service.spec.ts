import { TestBed } from '@angular/core/testing';

import { UserStateService } from './userstate.service';

describe('UserStateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserStateService = TestBed.get(UserStateService);
    expect(service).toBeTruthy();
  });
});
