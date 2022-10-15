package org.bcit.comp2522.lectures.ll03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapConverter {
  public HashMap<String, String> zipHashMap(Collection<String> keys, Collection<String> vals) throws Exception {
    if (keys.size() != vals.size()) {
      throw new Exception("Two different sized collections cannot be zipped.");
    }
    HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator<String> keysIterator = keys.iterator();
    Iterator<String> valuesIterator = vals.iterator();

    while(keysIterator.hasNext()) {
      hashMap.put(keysIterator.next(), valuesIterator.next());
    }

    return hashMap;
  }
}
