
import java.util.*;
//public class BinHeap<E extends Comparable<? super E>>  implements PrioQueue<E>{
public class BinHeap<E> implements PrioQueue<E>{
    private ArrayList<E> arrayRep;
    private Comparator<? super E> comp;
    
    public BinHeap(Comparator<? super E> comp) { 

	arrayRep=new ArrayList<E>();
	this.comp=comp;

    }
    public void add(E e){
	arrayRep.add(e);

	if(arrayRep.size()>1){
	    int currentIndex=arrayRep.size()-1;
	    bubbleUp(currentIndex);
	}
    }

    public E peek(){
	if(arrayRep.size()==0){
	    return null;
	}
	return arrayRep.get(0);
    }
    public E poll(){
	//	E result=arrayRep.remove(0);
	if( arrayRep.size()==0){
	    return null;
	}else if(arrayRep.size()==1){
	    return arrayRep.remove(0);
	}
	    
	
	swap(0,arrayRep.size()-1);
	E result =arrayRep.remove(arrayRep.size()-1);
	
	bubbleDown(0);
	return result;
    }
    // @Overridde 
    public void remove(E e){
	if(arrayRep.size()==1){
	    arrayRep.clear();
	}else if(arrayRep.size()!=0){
	    for(int i=0;i<arrayRep.size();i++){
		if(comp.compare(e,arrayRep.get(i))==0){
		    swap(i,arrayRep.size()-1);
		    arrayRep.remove(arrayRep.size()-1);
		    bubbleDown(i);
		    break;
		}
	    }
	}
    }	
	

    public void swap(int i,int j){
	E temp=arrayRep.get(i);
	arrayRep.set(i,arrayRep.get(j));
	arrayRep.set(j,temp);
    }
    public void bubbleUp(int startingIndex){
	int parentIndex;
	int currentIndex=startingIndex;
	while(true){
	    parentIndex=(currentIndex-1)/2;
	    if(comp.compare(arrayRep.get(currentIndex),arrayRep.get(parentIndex))<0){
		swap(currentIndex,parentIndex);
		currentIndex=parentIndex;
	    }else{
		break;
	    }
	}
    }
    public void bubbleDown(int startingIndex){
	int currentIndex=startingIndex;
	int childIndex;
	while(true){
	    childIndex=2*currentIndex+1;
	    if(comp.compare(arrayRep.get(childIndex),arrayRep.get(childIndex+1))>0){
		childIndex++;
	    }
	    if(comp.compare(arrayRep.get(childIndex),arrayRep.get(currentIndex))<0){
		swap(currentIndex,childIndex);
		currentIndex=childIndex;

	    }else{
		break;
	    }
	}
	
    }
    
      public Iterator<E> iterator(){
	  // public iterator(){
	  return new iterator();
      }

    
    private class iterator implements Iterator<E> {
       
	    private int currentIndex;
	    public iterator(){
		currentIndex=0;
	    }

	    @Override
	    public boolean hasNext() {
		return currentIndex<arrayRep.size()-1;
	    }
	   
	    @Override
	    public E next(){
		if(! hasNext()){ throw new NoSuchElementException();}
		else{return arrayRep.get(currentIndex++);}
	    }
	    @Override
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
	
      
    }
    
	
   

}
//
//
	
	
	
 







