import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeeventComponent } from './listeevent.component';

describe('ListeeventComponent', () => {
  let component: ListeeventComponent;
  let fixture: ComponentFixture<ListeeventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeeventComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeeventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
