import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroNegocioComponent } from './registro-negocio.component';

describe('RegistroNegocioComponent', () => {
  let component: RegistroNegocioComponent;
  let fixture: ComponentFixture<RegistroNegocioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistroNegocioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistroNegocioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
