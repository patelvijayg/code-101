import java.util.LinkedHashMap;
import java.util.Map;

public class LT146_LRUCache {
    int cap;
    Map<Integer,Integer> map;
    public LT146_LRUCache(int capacity) {
        //Option 1 we dont need to take care of get or put method as it handles directly
        //From linkedHashap documentation
        //        It provides the implementor with the opportunity to remove the eldest entry each time a new one
        //        is added.  This is useful if the map represents a cache:
        Map<Integer, Integer> mapCache =
                new LinkedHashMap<Integer, Integer>(capacity, 1, true) {
                    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> me) {
                        if (size() > capacity)
                            return true;
                        return false;
                    }
                };
        //Option 2
        map = new LinkedHashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            int ans = map.get(key);
            map.remove(key);
            map.put(key,ans);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            map.remove(key);
            map.put(key,value);
        }
        else
        {
            map.put(key,value);
            int size = map.size();

            if(size>cap)
            {
                int oldkey = map.keySet().iterator().next();
                map.remove(oldkey);
            }
        }
    }
}
