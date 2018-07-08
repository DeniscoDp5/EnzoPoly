package utils;
public class MapNode<K,V> implements Comparable<MapNode<K,V>>{

    K key;
    V value;

    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public int compareTo(MapNode<K,V> o){
        if(o.getKey() == this.key){
            return 0;
        }
        return 1;
    }
    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if(!(other instanceof MapNode)) return false;
        MapNode<K,V> n = (MapNode<K,V>) other;

        if(n.getKey().equals(this.key)){ //TODO: 
            return true;
        }else{
            return false;
        }

    }
}