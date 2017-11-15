import java.util.Iterator;

public class StockTrade {
    private PrioQueue<Bid> sellersQueue;
    private PrioQueue<Bid> buyersQueue;

    public StockTrade() {
        sellersQueue=new BinHeap(/*TODO ARGUMENT*/);
        buyersQueue = new BinHeap(/*TODO ARGUMENT*/);
        
    }

    public Transaction placeSellBid(Bid bid) {  }
    public Transaction placeBuyBid(Bid bid) { }

    public Iterator<Bid> sellBidsIterator() {
        return sellersQueue.iterator();
    }

    public Iterator<Bid> buyBidsIterator() {
        return buyersQueue.iterator();
    }
}
