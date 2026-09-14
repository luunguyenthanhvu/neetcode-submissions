
class MyHashMap {
    private List<Entry>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new List[10];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Entry>();
        }
    }

    private int getIndex(int key) {
        return Math.abs(key) % buckets.length;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        List<Entry> entryList = buckets[index];
        for(Entry e :entryList) {
            if(e.getKey() == key) {
                e.setValue(value);

                return;
            }
        }
        entryList.add(new Entry(key, value));
    }

    public int get(int key) {
        int index = getIndex(key);
        List<Entry> entryList = buckets[index];
        for(Entry e :entryList) {
            if(e.getKey() == key) {
                return e.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Entry> entryList = buckets[index];
        for(int i =0; i < entryList.size(); i++) {
            if(entryList.get(i).getKey() == key) {
                entryList.remove(i);
                return;
            }
        }
    }
}

class Entry {
    int key;
    int value;

    public Entry() {

    }
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