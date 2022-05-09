import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCourfontComponent } from './list-courfont.component';

describe('ListCourfontComponent', () => {
  let component: ListCourfontComponent;
  let fixture: ComponentFixture<ListCourfontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCourfontComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCourfontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
