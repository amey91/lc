package javasolutions;

public class MyHashMap<K extends Comparable<?>, V> {
	public static final int MAX_SIZE = 256;
	public static final int INITIAL_SIZE = 8;
	public static final int REPLICATION_FACTOR = 2;
	public static final float REPLICATION_THRESHOLD = 0.75f; 
	
	Entry<K,V>[] table;
	public MyHashMap(){
		table = new Entry[INITIAL_SIZE];
	}
	
	public static int getKey(Object ob){
		return ob.hashCode();
	}
	
}

class Entry<K extends Comparable<?>,V>{
	K key;
	V value;
	
	public Entry(K key, V value){
		this.key=key;
		this.value=value;
	}
}
