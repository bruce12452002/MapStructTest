package enu;

public enum MyEnum {
  MY_ENUM_A("a"),
  MY_ENUM_B("b"),
  MY_ENUM_C("c"),
  MY_ENUM_X("x"),
  MY_ENUM_Y("y"),
  MY_ENUM_Z("z");

  private final String v;

  MyEnum(String v) {
    this.v = v;
  }

  public String getV() {
    return v;
  }
}
