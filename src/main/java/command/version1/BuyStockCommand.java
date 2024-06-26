package command.version1;
// buy command does nothing but invoke the buy feature of receiver
public class BuyStockCommand implements Command {
    private StockTradeReceiver receiver;

    public BuyStockCommand(StockTradeReceiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.buy();
    }
}
