// IdentityHashMap is a special implementation of the Map interface in Java that compares keys and values using reference equality (==) instead of object equality (equals()), which is used by HashMap.

package Collections.MapInterface.IdentityHashMap;

import java.util.HashMap;
import java.util.Map;

public class IdentityHashMap {
    public static void main(String[] args) {
        // HashMap will replace similar key with the latest key created
        String key1 = new String("Key");
        String key2 = new String("Key");
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        //  HashMap keys are considered equal if their equals() method returns true, so distinct objects with equal content replace each other's values when used as keys.
        System.out.println("Equal keys: " + key1.equals(key2));
        System.out.println("Hashcode of key1: " + key1.hashCode() + ", hashcode of key2: " + key2.hashCode() );  // returns the same integer value for different String objects that have the same character content.
        System.out.println("Map: " + map);

        // IdentityHashCode and ==
        Map<String, Integer> idMap = new java.util.IdentityHashMap<>();
        idMap.put(key1, 1);
        idMap.put(key2, 2);
        System.out.println("IdentityHashMap: " + idMap); // will print both entries as the keys are separate objects

        String idKey1 = new String("IdKey");
        String idKey2 = new String("IdKey");
        idMap.put(idKey1, 3);
        idMap.put(idKey2, 4);
        System.out.println("IdentityHashMap: " + idMap);
        idMap.put(idKey1, 5);
        System.out.println("Should replace the (idKey1, 3) entry:" + idMap);  // replaces as the keys belong to the same object
        System.out.println("IdentityHashCode idKey1:" + System.identityHashCode(idKey1));
        System.out.println("IdentityHashCode idKey2:" + System.identityHashCode(idKey2)); // hashcodes will be different as it provides hashcodes based on object but not based on object's content like hashCode()
    }
}
