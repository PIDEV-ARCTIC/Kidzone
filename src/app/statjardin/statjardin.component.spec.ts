import { ComponentFixture, TestBed } from '@angular/core/testing';

import { STATJardinComponent } from './statjardin.component';

describe('STATJardinComponent', () => {
  let component: STATJardinComponent;
  let fixture: ComponentFixture<STATJardinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ STATJardinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(STATJardinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
