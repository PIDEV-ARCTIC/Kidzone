import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCoursComponent } from './list-cours.component';

describe('ListCoursComponent', () => {
  let component: ListCoursComponent;
  let fixture: ComponentFixture<ListCoursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCoursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
