package utils;

import java.util.Iterator;
import utils.List;
import utils.MapNode;

/**
 * This ADT implements an HasMap between a key and an object
 * The map can be empty. When a key is add it must be added a value too
 */
public class MapGrammar<K,V>{

    public List<MapNode<K,V>> map; // Todo set to private and implement an iterator for the keys
    
    public MapGrammar(){
        this.map = new List<MapNode<K,V>>();
    }

    /**
     * Add a new relation between the key and the value, if the key is already present in the set,
     * the new value is overrided
     * @param key the key 
     * @param value the vlue to associate with the key
     * @throws Exception if the key is already in relation with another key
     */
    public void add(K key, V value) throws UnsupportedOperationException{ //TODO use the new isIn method of List
        MapNode<K,V> tmp = new MapNode<K,V>(key,value);

        Iterator<MapNode<K,V>> it =  this.map.iterator();

        MapNode<K,V> x = it.next();
        boolean bool = true;
        
        while(x != null && bool){
            if(x.equals(tmp)){
                bool = false;
            }
            x = it.next();
        }

        if( bool == false){
            x.value = value;
        }else{
            this.map.add(tmp);
        }
    }
    /**
     * This method returns the value associated with the key
     * Returns null if the key is not in the keys set
     * @param key the key to look for
     * @return The value associate with the key if present, null otherwise
     */
    public V getValue(K key){

        Iterator<MapNode<K,V>> it =  this.map.iterator();
        if (it == null){
            return null;
        }
        MapNode<K,V> x = it.next();
        while(x != null && !x.getKey().equals(key)){
            x = it.next();
        }

        if(x == null){
            return null;
        }else{
            return x.getValue();
        }
    }

}
