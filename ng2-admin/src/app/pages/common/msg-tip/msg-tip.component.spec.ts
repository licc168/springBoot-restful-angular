/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from "@angular/core/testing";

import {MsgTipComponent} from "./msg-tip.component";

describe('ErrorTipComponent', () => {
  let component: MsgTipComponent;
  let fixture: ComponentFixture<MsgTipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MsgTipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MsgTipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
