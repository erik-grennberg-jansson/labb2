
import java.util.*;
public class BinHeap<E extends Comparable<? super E>>  implements PrioQueue<E>{

    private ArrayList arrayRep;

    
    public BinHeap(Comparator<? super E> comp) { 

	arrayRep=new ArrayList();

    }
    public void add(E e){
	arrayRep.add(e);



	if(arrayRep.size()>1){
	    int currentIndex=arrayRep.size()-1;
	    boolean needForBubble=true;
	    int parentIndex;
	 
	    while(needForBubble){
		parentIndex=(currentIndex-1)/2;
		if(comp.compare(arrayRep.get(currentIndex),arrayRep.get(parentIndex))<0){
		    swap(currentIndex,parentIndex);
		    currentIndex=parentIndex;
		}
		else{
		    needForBubble=false;
		}
	    }
	}
    }

    public E peek(){
	return arrayRep.get(0);



    }
    public E poll(){
	//	E result=arrayRep.remove(0);
	swap(0,arrayRep.size()-1);
	E result =arrayRep.remove(arrayRep.size()-1);
	int currentIndex=0;
	int childIndex;
	while(true){
	    childIndex=2*currentIndex+1;
	    if(compare(arrayRep.get(childIndex),arrayRep.get(childIndex+1))>0){
		childIndex++;
	    }
	    if(compare(arrayRep.get(childIndex),arrayRep.get(currentIndex))<0){
		swap(currentIndex,childIndex);
		currentIndex=parentIndex;

	    }else{
		break;
	    }

	    



	}
	
	
    }
    // @Overridde 
    public void remove(E e){
	for(int i=0;
	
    }
    public void swap(int i,int j){
	E temp=arrayRep.get(i);
	arrayRep.set(i,arrayRep.get(j));
	arrayRep.set(j,temp);
    }

    /*    public static void bubble(){
      int insertedIndex=arrayRep.size()-1;
      }*/
    public Iterator<E> iterator() {
	Iterator<E> it =new Iterator<E>(){
	    private int currentIndex=0;
	    @Override
	    public boolean hasNext() {
		return currentIndex<arrayRep.size-1;
	    }
	    @Override
	    public E next(){
		return arrayRep.get(currentIndex++);
	    }
	    @Override
	    public void remove(){
		throw new UnsupportedOperationExpection();
	    }
	};
	return it;
    }
}
	
	
	
 







