package command.version1;

// receiver , which have the actual implementation of the functionalities,
// which knows about the implementation of buy and sell
public class StockTradeReceiver {
    public void buy(){
        System.out.println("Buying stock");
    }
    public void sell(){
        System.out.println("Selling stock");
    }
}
