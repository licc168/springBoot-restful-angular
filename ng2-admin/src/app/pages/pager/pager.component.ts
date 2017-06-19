/**
 * @time 2017-04-28 分页插件的封装
 * @author lichangchao
 */
import {Component, ViewEncapsulation,Input,Output,EventEmitter} from '@angular/core';
import {Router} from "@angular/router";
@Component({
	selector: 'pager',
	encapsulation: ViewEncapsulation.None,
	template: require('./pager.component.html')
})
export class Pager {
	private curPage=1; // 当前页
	private totalPages; // 总页数
	private totalElements; // 总条数
	@Input()
	set totalPage ( _totalPages ) {
		this.totalPages = _totalPages;
	}
	@Input()
	set totalElement ( _totalElements ) {
		this.totalElements = _totalElements;
	}
	@Input()
	set page (_pages) {
		this.curPage = _pages;
	}
	@Output()
	output:EventEmitter<any> = new EventEmitter();

	constructor(private router:Router) {

	}

	ngOnInit() {
	}

	// 跳转到首页
	firstPage () {
		this.curPage = 1;
		this.output.emit(1);
	}
	// 跳转到尾页
	lastPage () {
		this.curPage = this.totalPages;
		this.output.emit(this.totalPages);
	}
	// 上一页
	prevPage () {
		if( this.curPage <= 1 ) {
			return false;
		}
		this.curPage--;
		this.output.emit(this.curPage);
	}
	// 下一页
	nextPage () {
		if( this.curPage >= this.totalPages ) {
			return false;
		}
		this.curPage++;
		this.output.emit(this.curPage);
	}
	// 跳转页数
	jumpPage ( number ) {
		if( number > this.totalPages ) {
			this.curPage = this.totalPages;
			this.output.emit(this.totalPages);
		} else if( number < 1 ) {
			this.curPage = 1;
			this.output.emit(1);
		} else {
			this.curPage = Math.floor(number);
			this.output.emit(this.curPage);
		}
	}
}
