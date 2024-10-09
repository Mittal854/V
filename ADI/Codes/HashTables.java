import java.util.*;

class NormalHashTable {
    int tableSize;
    Integer[] hashTable;

    NormalHashTable(int tableSize) {
        this.tableSize = tableSize;
        hashTable = new Integer[tableSize];
    }

    void add(int key) {
        int index = key % tableSize;
        hashTable[index] = key;
    }

    void remove(int key) {
        int index = key % tableSize;
        hashTable[index] = null;
    }

    boolean isPresent(int key) {
        int index = key % tableSize;
        return hashTable[index] != null;
    }
}

class OpenAddressing {
    int tableSize;
    Integer[] hashTable;

    OpenAddressing(int tableSize) {
        this.tableSize = tableSize;
        hashTable = new Integer[tableSize];
    }

    void add(int key) {
        int index = key % tableSize;
        int oldIndex = index;
        int i = 1;
        do {
            if (hashTable[index] != null) {
                index = (index + i * i) % tableSize; // quadratic probing
                i++;
            } else {
                hashTable[index] = key;
                return;
            }
        } while (index != oldIndex);
    }

    void remove(int key) {
        int index = key % tableSize;
        int oldIndex = index;
        int i = 1;
        do {
            if (hashTable[index] == key) {
                hashTable[index] = null;
                return;
            } else if (hashTable[index] != null) {
                index = (index + i * i) % tableSize; // quadratic probing
                i++;
            }
        } while (index != oldIndex);
    }
}

class SeparateChaining<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] hashTable;
    private int tableSize; // size of the table
    private int size; // number of hash nodes present in the table

    SeparateChaining(int tableSize) {
        this.tableSize = tableSize;
        hashTable = new HashNode[tableSize];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    private int getHashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getHashTableIndex(K key) {
        int index = getHashCode(key) % tableSize;
        return index < 0 ? (-1 * index) : index;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        int index = getHashTableIndex(key);
        // search for key and update the value if it is there
        HashNode<K, V> head = hashTable[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // add the key
        size++;
        head = hashTable[index];
        HashNode<K, V> newHN = new HashNode<>(key, value);
        newHN.next = head;
        hashTable[index] = newHN;
    }

    public V remove(K key) {
        int index = getHashTableIndex(key);
        HashNode<K, V> head = hashTable[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;
        if (prev != null) prev.next = head.next;
        else hashTable[index] = head.next;

        size--;
        return head.value;
    }
}

class LinearProbingGenerics<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }

    int hashTableSize;

    private HashNode<K, V>[] hashTable;
    LinearProbingGenerics(int hashTableSize) {
        this.hashTableSize = hashTableSize;
        hashTable = new HashNode[hashTableSize];
    }

    private int getHashCode (K key) {
        return Objects.hashCode(key);
    }

    public int getHashTableIndex (K key) {
        int index = getHashCode(key) % hashTableSize;
        return (int) Math.abs(index);
    }

    public void add (K key, V value) {
        int index = getHashTableIndex(key);
        int oldIndex = index;

        do {
            if(hashTable[index] == null) {
                hashTable[index] = new HashNode<>(key, value);
                return;
            }

            if (++index == hashTableSize) index = 0;
        }  while (index != oldIndex);
    }

    void remove (K key) {
        int index = getHashTableIndex(key);
        int oldIndex = index;

        do {
            if(hashTable[index].key == key) {
                hashTable[index] = null;
                return;
            }
            if (index == hashTableSize) index = 0;
        }  while (index != oldIndex);
    }

    public boolean isPresent(K key) {
        int index = getHashTableIndex(key);
        int oldIndex = index;
        do {
            if(hashTable[index] != null && hashTable[index].key == key) {
                return true;
            }
            if (++index == hashTableSize) index = 0;
        }  while (index != oldIndex);
        return false;
    }

    public  void print() {
        for(int i = 0; i < hashTableSize; i++) {
            if(hashTable[i] != null)
                System.out.println(hashTable[i].key + " " + hashTable[i].value);
        }
    }

}

public class HashTables {
    public static void main(String[] args) {
        NormalHashTable nht = new NormalHashTable(10);

        nht.add(15);
        nht.add(24);
        nht.add(39);
        nht.add(3);

        System.out.println(nht.isPresent(39)); // Output: true

        nht.remove(39);

        System.out.println(nht.isPresent(39)); // Output: false
    }
}
