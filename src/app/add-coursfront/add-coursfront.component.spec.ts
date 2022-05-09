import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCoursfrontComponent } from './add-coursfront.component';

describe('AddCoursfrontComponent', () => {
  let component: AddCoursfrontComponent;
  let fixture: ComponentFixture<AddCoursfrontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCoursfrontComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCoursfrontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
