import { TestBed } from '@angular/core/testing';

import { KingmakerService } from './kingmaker.service';

describe('KingmakerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KingmakerService = TestBed.get(KingmakerService);
    expect(service).toBeTruthy();
  });
});
