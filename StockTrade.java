import java.util.Iterator;

public class StockTrade {
    private PrioQueue<Bid> sellersQueue;
    private PrioQueue<Bid> buyersQueue;
    
    private class SellersComparator implements Comparator<Bid>{
        public int compare(Bid bid1,Bid bid2){
            int first=bid1.price;
            int second= bid2.price;
            if(first<second){
                return 1;
            }
            else if(second<first){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
    private class BuyersComparator implements Comparator<Bid>{
        public int compare(Bid bid1, Bid bid2){
            int first=bid1.price;
            int second= bid2.price;
            if(first<second){
                return -1;
            }
            else if(second<first){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    
    public StockTrade() {
        sellersQueue=new BinHeap(/*TODO ARGUMENT*/new SellersComparator());
        buyersQueue = new BinHeap(/*TODO ARGUMENT*/new BuyersComparator());
        
    }

    public Transaction placeSellBid(Bid bid) {
        Iterator<Bid> iter = new sellersBidIterator();
        while(iter.hasNext()){
            Bid temp = iter.next();
            if(bid.name.equals(temp.name)){
                sellersQueue.remove(temp);
                
                break;
            }
            
        }
        sellersQueue.add(bid);
        Iterator<Bid> iter = new buyBidsIterator();
        while(iter.hasNext()){
            Bid buyTemp=iter.next();
            if(bid.price<=buyTemp.price){
                buyersQueue.remove(buyTemp);
                sellersQueue.remove(bid);
                return new Transaction(bid.name,buyTemp.name,buyTemp.price);
                
            }
                
        }
        return null;
        
    }
    public Transaction placeBuyBid(Bid bid) {
        
        
    }

    public Iterator<Bid> sellBidsIterator() {
        return sellersQueue.iterator();
    }

    public Iterator<Bid> buyBidsIterator() {
        return buyersQueue.iterator();
    }
}
