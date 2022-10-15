package org.bcit.comp2522.lectures.ll03;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    HashMap<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("Hello", "world");
    hashMap.put("world", "Hello");
    System.out.format("%s, %s!", hashMap.get("world"), hashMap.get("Hello"));
  }
}