import {page} from "./page";
export class Menu extends page {
  private id: number;
  public parentId: number;
  public title: String;
  public deleteFlag: boolean =false;
  public expanded:boolean = false;
  public selected:boolean = false;
  public  orderNum:number;
  
  public setTitle(_title):void{
  	this.title = _title;
  }
  public setId(_id):void{
  	this.id = _id;
  }
    public setParentId(_parentId):void{
  	this.parentId = _parentId;
  }
    public setOrderNum(_orderNum):void{
  	this.orderNum = _orderNum;
  }
  
}

