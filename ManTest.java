
public class ManTest{

	public static void main(String[] args){
		PrioQueue<Integer> pq = new BinHeap<>(new NaturalOrderComparator<Integer>());
	pq.poll();  // result: null
	pq.add(8);
	pq.add(4);
	pq.add(8);
	pq.remove(9);
	pq.add(10);
	pq.remove(8);
	pq.poll();  // result: 4
	pq.remove(9);
	pq.remove(5);
	pq.remove(5);
	pq.poll();  // result: 10
	}
}
