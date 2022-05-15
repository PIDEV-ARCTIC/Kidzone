import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateabsenceComponent } from './updateabsence.component';

describe('UpdateabsenceComponent', () => {
  let component: UpdateabsenceComponent;
  let fixture: ComponentFixture<UpdateabsenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateabsenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateabsenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
