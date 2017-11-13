
import java.util.*;
public class BinHeap<E extends Comparable<? super E>>  implements PrioQueue<E>{

    private ArrayList arrayRep;

    
    public BinHeap(Comparator<? super E> comp) { 

	arrayRep=new ArrayList();

    }
    public void add(E e){
	arrayRep.add(e);



	if(arrayRep.size()>0){
	    int currentIndex=arrayRep.size()-1;
	    boolean needForBubble=true;
	    
	 
	    while(needForBubble){
		int parentIndex=(currentIndex-1)/2;
		if(compare(arrayRep.get
	    }
	}
    }

    public E peek(){
	return arrayRep.get(0);





    }
    public void remove(E e){
	
	
    }

    /*    public static void bubble(){
      int insertedIndex=arrayRep.size()-1;
      }*/
}
	
	
	
 







