package enu;

public enum MyEnum2 {
  MY_ENUM_C("c"),
  MY_ENUM_D("d"),
  MY_ENUM_E("e");

  private final String v;

  MyEnum2(String v) {
    this.v = v;
  }

  public String getV() {
    return v;
  }
}
