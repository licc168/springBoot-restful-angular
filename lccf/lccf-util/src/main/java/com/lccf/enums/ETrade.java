package com.lccf.enums;

/**
 *
 *
 * @author lichangchao
 * @date 2017 /5/17 11:09
 * @version 1.0.0
 * @see
 */
public enum ETrade {
  ETC("etc"),
  LTC("ltc");
  private String value;
  ETrade( String value){
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
