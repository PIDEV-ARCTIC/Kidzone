import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialoginfoBusComponent } from './dialoginfo-bus.component';

describe('DialoginfoBusComponent', () => {
  let component: DialoginfoBusComponent;
  let fixture: ComponentFixture<DialoginfoBusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialoginfoBusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialoginfoBusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
