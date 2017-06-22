import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'msgTip',
  templateUrl: './msg-tip.component.html',
  styleUrls: ['./msg-tip.component.scss']
})
export class MsgTipComponent implements OnInit {
  private msg;
  private open = false;
  @Input()
  set message( _msg ) {
  	this.msg = _msg;
  }
  @Input()
  set isOpen ( _open ) {
  	this.open = _open;
  }
  @Output()
  output:EventEmitter<any> = new EventEmitter();

  constructor() {

  }

  ngOnInit() {

  }

  // 点击确定
  confirm () {
  	this.open = false;
  	this.output.emit(false);
  }

}
