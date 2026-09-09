class MyHashSet {

    private List<Integer>[] buckets;
    private int size;

    public MyHashSet() {
        buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int getIndex(int key) {
        return Math.abs(key) % buckets.length;
    }

    public void add(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets[index];

        if (!bucket.contains(key)) {
            bucket.add(key);
            size++;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets[index];

        if (bucket.remove(Integer.valueOf(key))) {
            size--;
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */