class TimeMap {
    Map<String, TreeMap<Integer, String>> tm;

    public TimeMap() {
        tm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        tm.putIfAbsent(key, new TreeMap<Integer, String>());

        tm.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!tm.containsKey(key)) return "";

        TreeMap<Integer, String> inner = tm.get(key);
        List<Integer> times = new ArrayList<>(inner.keySet());  

        int l = 0;
        int r = times.size() - 1;
        int resIdx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int t = times.get(mid);
            if (t <= timestamp) {
                resIdx = mid;       
                l = mid + 1;       
            } else {
                r = mid - 1;
            }
        }

        if (resIdx == -1) return ""; 

        int bestTime = times.get(resIdx);
       
        return inner.get(bestTime);
    }
}
