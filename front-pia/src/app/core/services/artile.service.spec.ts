import { TestBed } from '@angular/core/testing';

import { ArtileService } from './artile.service';

describe('ArtileService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ArtileService = TestBed.get(ArtileService);
    expect(service).toBeTruthy();
  });
});
