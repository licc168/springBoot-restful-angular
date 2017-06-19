import {page} from "./page";
export class Menu extends page {
  private id: number;
  public parentId: number;
  public title: String;
  public deleteFlag: boolean =false;
  public expanded:boolean = false;
  public selected:boolean = false;
  public  orderNum:number;


}

