package org.bcit.comp2522.lectures.ll03;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HashMapConverterTest {

  @Test
  void zipHashMap() {
    HashMapConverter hmc = new HashMapConverter();
    LinkedList<String> strs1 = new LinkedList<String>();
    strs1.add("Father");
    strs1.add("Charles");
    strs1.add("Goes");
    strs1.add("Down");
    strs1.add("And");
    strs1.add("Ends");
    strs1.add("Battle");

    LinkedList<String> strs2 = (LinkedList<String>) strs1;
    Collections.reverse(strs2);

    HashMap<String, String> hashMap = new HashMap<String, String>();
    Iterator<String> keysIterator = strs1.iterator();
    Iterator<String> valuesIterator = strs2.iterator();

    while (keysIterator.hasNext()) {
      hashMap.put(keysIterator.next(), valuesIterator.next());
    }

    try {
      HashMap<String, String> testHashMap = hmc.zipHashMap(strs1, strs2);
      Iterator<String> testKeysIterator = strs1.iterator();
      Iterator<String> testValuesIterator = strs2.iterator();

      while (testKeysIterator.hasNext()) {
        assertEquals(testValuesIterator.next(),
          testHashMap.get(testKeysIterator.next()));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    }
}