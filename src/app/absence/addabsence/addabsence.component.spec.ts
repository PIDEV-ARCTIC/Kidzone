import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddabsenceComponent } from './addabsence.component';

describe('AddabsenceComponent', () => {
  let component: AddabsenceComponent;
  let fixture: ComponentFixture<AddabsenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddabsenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddabsenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
