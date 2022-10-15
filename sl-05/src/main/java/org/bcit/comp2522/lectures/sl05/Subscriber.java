package org.bcit.comp2522.lectures.sl05;

public class Subscriber extends AbstractObserver {
  String lastMsg;
  @Override
  public String update(String msg) {
    lastMsg = msg;
    String ret = String.format("%s: %s\n", this.toString(), msg);
    System.out.println(ret);
    return ret;
  }
}
