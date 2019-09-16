import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KingmakerComponent } from './kingmaker.component';

describe('KingmakerComponent', () => {
  let component: KingmakerComponent;
  let fixture: ComponentFixture<KingmakerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KingmakerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KingmakerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
