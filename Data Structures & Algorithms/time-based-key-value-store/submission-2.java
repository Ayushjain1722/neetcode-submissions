class Value {
    int timestamp;
    String val;
    Value(int timestamp, String val) {
        this.val = val;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    // HashMap<String, HashMap<Integer, Stirng>> map;
    HashMap<String, List<Value>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            // HashMap<Integer, String> val = map.get(key);
            //     val.put(timestamp, value);
            List<Value> temp = map.get(key);
            temp.add(new Value(timestamp, value));
        } else {
            // HashMap<Integer, String> temp = new HashMap<Integer, String>();
            // temp.put(timestamp, value);
            List<Value> temp = new ArrayList<>();
            temp.add(new Value(timestamp, value));
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key) || map.get(key).get(0).timestamp > timestamp) return "";
        else {
            List<Value> temp = map.get(key);
            int l = 0;
            int r = temp.size()-1;
            int index = l;
            while(l <= r) {
                int mid = l + (r-l)/2;
                if(temp.get(mid).timestamp <= timestamp) {
                    index = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return temp.get(index).val;
        }
    }
}
