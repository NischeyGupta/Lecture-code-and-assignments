package org.bcit.comp2522.lectures.ll04;

public class Main {
  public static void main(String[] args) {
    DFSTree<String> tree = new DFSTree<String>();
    tree.add("A");
    tree.addTo(tree.get("A"), "B");
    tree.addTo(tree.get("B"), "C");
    tree.addTo(tree.get("C"), "D");
    tree.addTo(tree.get("D"), "E");
    tree.addTo(tree.get("B"), "F");
    tree.addTo(tree.get("B"), "G");

    System.out.print(tree);

  }
}