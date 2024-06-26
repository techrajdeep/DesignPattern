package command.version1;

public class Client {
    public static void main(String[] args) {
        StockTradeReceiver receiver= new StockTradeReceiver();
        BuyStockCommand buyCommand= new BuyStockCommand(receiver);
        SellStockCommand sellCommand= new SellStockCommand(receiver);
        //v1 agent
        AgentInvoker agent= new AgentInvoker(buyCommand);
        agent.placeOrder();

        //v2 agent
        AgentInvokerV2 agentV2=new AgentInvokerV2();

        agentV2.placeOrder();

        agentV2.setOrder(buyCommand);
        agentV2.placeOrder();

        agentV2.setOrder(sellCommand);
        agentV2.placeOrder();

        agentV2.placeOrder();

        //v3 agent
        AgentInvokerV3 agentV3=new AgentInvokerV3();
        agentV3.placeOrder(buyCommand);
        agentV3.placeOrder(sellCommand);
        agentV3.placeOrder(buyCommand);
        agentV3.execute();
    }
}
