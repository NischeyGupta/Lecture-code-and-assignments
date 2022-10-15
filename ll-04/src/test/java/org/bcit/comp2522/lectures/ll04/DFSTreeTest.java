package org.bcit.comp2522.lectures.ll04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DFSTreeTest {
  DFSTree<String> tree;

  @BeforeEach
  void setUp() {
    tree = new DFSTree<String>();
    tree.add("A");
    tree.addTo(tree.get("A"), "B");
    tree.addTo(tree.get("B"), "C");
    tree.addTo(tree.get("C"), "D");
    tree.addTo(tree.get("D"), "E");
    tree.addTo(tree.get("B"), "F");
    tree.addTo(tree.get("B"), "G");
  }

  @Test
  void iterationTest() {
    String[] expected = {"A", "B", "C", "D", "E", "F", "G"};
    String[] actual = new String[expected.length];
    int i = 0;
    for (String s : tree) {
      actual[i] = s;
      i++;
    }
    assertArrayEquals(expected, actual);
  }

  @Test
  void additionTest() {
    String[] expected = {"A", "B", "C", "D", "E", "F", "H", "I", "G"};
    String[] actual = new String[expected.length];
    tree.addTo(tree.get("F"), "H");
    tree.addTo(tree.get("F"), "I");
    int i = 0;
    for (String s : tree) {
      actual[i] = s;
      i++;
    }
    assertArrayEquals(expected, actual);
  }
}