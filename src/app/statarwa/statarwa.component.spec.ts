import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatarwaComponent } from './statarwa.component';

describe('StatarwaComponent', () => {
  let component: StatarwaComponent;
  let fixture: ComponentFixture<StatarwaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatarwaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatarwaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
