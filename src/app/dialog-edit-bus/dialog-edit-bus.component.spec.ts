import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogEditBusComponent } from './dialog-edit-bus.component';

describe('DialogEditBusComponent', () => {
  let component: DialogEditBusComponent;
  let fixture: ComponentFixture<DialogEditBusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogEditBusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogEditBusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
