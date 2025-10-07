// Uses weak references for keys only. Values are strongly referenced.
// When a key becomes weakly reachable (i.e., no strong references outside the map), its entry can be garbage collected.
// Supports one null key and multiple null values.
// Not synchronized by default (not thread-safe).

package Collections.MapInterface.WeakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        // Here keys are string literals that are stored in string pools which are strongly referenced
        //imageCache.put("img1", new Image("Image 1"));
        //imageCache.put("img2", new Image("Image 2"));
        String key1 = new String("img1");
        String key2 = new String("img2");
        imageCache.put(key1, new Image("Image 2"));
        imageCache.put(key2, new Image("Image 2"));
        // OR
        //imageCache.put(new String("img1"), new Image("Image 2"));
        //imageCache.put(new String("img2"), new Image("Image 2"));
        System.out.println(imageCache);
        // To make it a weak reference (if declared in separate variables)
        key1 = null;
        key2 = null;
        System.gc(); // no effect of garbage collector
        simulateApplicationRunning();
        System.out.println("Cache after running (some entries may be cleared): " + imageCache);

        //WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        //loadCache(imageCache);
        //System.out.println(imageCache);
        //System.gc();
        //simulateApplicationRunning();
        //System.out.println("Cache after running (some entries may be cleared): " + imageCache);
    }

    public static void loadCache(Map<String, Image> imageCache) {
        // Scope of the reference variables are up to this method only so when called it will be weakly referenced
        String k1 = new String("img1");
        String k2 = new String("img2");
        imageCache.put(k1, new Image("Image 1"));
        imageCache.put(k2, new Image("Image 2"));
    }

    private static void simulateApplicationRunning() {
        try {
            System.out.println("Simulating application running...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}