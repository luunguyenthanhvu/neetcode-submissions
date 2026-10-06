class MyHashMap {
    private List<Entry>[] buckets;
    private int capacity;
    private int size;
    private final double LOAD_FACTOR = 0.75;
    public MyHashMap() {
        capacity = 10;
        buckets = new List[capacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Entry>();
        }
    }

    private void resize() {
        capacity *= 2;
        List<Entry>[] oldBuckets = buckets;
        buckets = new List[capacity];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Entry>();
        }

        size = 0;
        for (int i = 0; i < oldBuckets.length; i++) {
            List<Entry> oldEntryList = oldBuckets[i];
            for (Entry e : oldEntryList) {
                put(e.getKey(), e.getValue());
            }
        }
    }

    private int getIndex(int key) {
        return Math.abs(key) % capacity;
    }

    public void put(int key, int value) {
        if ((double) size / capacity > LOAD_FACTOR)
            resize();
        int index = getIndex(key);
        List<Entry> entryList = buckets[index];
        for (Entry e : entryList) {
            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }
        }
        entryList.add(new Entry(key, value));
        size++;
    }

    public int get(int key) {
        int index = getIndex(key);
        List<Entry> entryList = buckets[index];
        for (Entry e : entryList) {
            if (e.getKey() == key) {
                return e.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Entry> entryList = buckets[index];
        for (int i = 0; i < entryList.size(); i++) {
            if (entryList.get(i).getKey() == key) {
                entryList.remove(i);
                size--;
                return;
            }
        }
    }
}

class Entry {
    int key;
    int value;

    public Entry() {}
    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
