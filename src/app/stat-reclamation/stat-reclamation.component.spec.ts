import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatReclamationComponent } from './stat-reclamation.component';

describe('StatReclamationComponent', () => {
  let component: StatReclamationComponent;
  let fixture: ComponentFixture<StatReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatReclamationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
