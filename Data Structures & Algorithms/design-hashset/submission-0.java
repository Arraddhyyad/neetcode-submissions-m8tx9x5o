class MyHashSet {
private List<Integer> Arr; 

    public MyHashSet() {
        Arr = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!Arr.contains(key))
            Arr.add(key);
    }
    
    public void remove(int key) {
        Arr.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return Arr.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */