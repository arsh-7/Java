package Collections;
import java.util.*;
public class Hashset<E> implements Set<E> {
    private int bucketsize;
    private float loadFactor;
    private ArrayList< Linkedlist<E> > bucket;
    private int size;
    public Hashset(int bsize,float loadFactor) {
        this.size = 0;
        this.bucketsize = bsize;
        this.loadFactor = loadFactor;
        this.bucket = new ArrayList<>(bsize);
        for ( int i = 0; i < bsize; i++) {
            bucket.add(new Linkedlist<E>());
        }
    }
    public Hashset() {
        this( 31, 0.75f);
    }
    @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                int i = 0;
                int count = 0;
                Iterator<E> it = bucket.get(i).iterator();
                public boolean hasNext() {
                    if( count < size ) return true;
                    return false;
                }
                public E next() {
                    while( i < bucketsize ) {
                        if(it.hasNext()) {
                            return it.next();
                        } else {
                            i++;
                            it = bucket.get(i).iterator();
                        }
                    }
                    throw new NoSuchElementException("no more elements");
                }
            };
        }
    @Override
        public void add(E e) {
            int bucketNumber=e.hashCode()%bucketsize;
            if(!(bucket.get(bucketNumber).contains(e))) {
                bucket.get(bucketNumber).add(e);
                size++;
            }   
            if((bucketsize*loadFactor)<=size) {
               // resize();
            }
        }
    @Override
        public boolean remove(E e) {
            int bucketNumber = e.hashCode()%bucketsize;
            boolean temp = bucket.get(bucketNumber).contains(e);
            if(temp) size--;
            bucket.get(bucketNumber).remove(e);
            return temp;
        }
    @Override
        public int size() { 
            return size; 
        }
    @Override
        public void clear() {
            for( int i = 0; i < bucketsize;i++) {
                bucket.get(i).clear();
            }
            size = 0;
        }
    @Override
        public boolean isEmpty() {
            if(size == 0) return true;
            return false;
        }
    @Override
        public boolean contains(E e) {
            int bucketNumber = e.hashCode()%bucketsize;
            return bucket.get(bucketNumber).contains(e);
        }
}
