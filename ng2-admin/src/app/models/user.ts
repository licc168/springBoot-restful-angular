import {page} from "./page";
export class User extends page {
  private id: number;
  public userName: String;
  public email: String;
  public realName: String;
  public mobile: String;
  public password: String;
  public passwords: Passwords;


}

export class Passwords {
  public password: String;
  public repeatPassword: String;


}
