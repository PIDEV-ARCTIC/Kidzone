import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatabsenceComponent } from './statabsence.component';

describe('StatabsenceComponent', () => {
  let component: StatabsenceComponent;
  let fixture: ComponentFixture<StatabsenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatabsenceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatabsenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
