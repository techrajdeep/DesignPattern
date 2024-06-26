package command.version1;
// sell command does nothing but invoke the sell feature of receiver
public class SellStockCommand implements Command {
    private StockTradeReceiver receiver;

    public SellStockCommand(StockTradeReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
      receiver.sell();
    }
}
