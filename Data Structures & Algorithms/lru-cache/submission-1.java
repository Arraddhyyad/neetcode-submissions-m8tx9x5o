class LRUCache {

    Map<Integer, Integer> cache;
    int MAX_ENTRIES;

    public LRUCache(int capacity) {
        MAX_ENTRIES = capacity; 
        cache = new LinkedHashMap<>(MAX_ENTRIES, 0.75f, true){

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
            return size()>LRUCache.this.MAX_ENTRIES;
        }
        };
        }
    
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
}

}
