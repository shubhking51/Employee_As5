import { TestBed } from '@angular/core/testing';

import { StudentLoginServiceService } from './student-login-service.service';

describe('StudentLoginServiceService', () => {
  let service: StudentLoginServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentLoginServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
