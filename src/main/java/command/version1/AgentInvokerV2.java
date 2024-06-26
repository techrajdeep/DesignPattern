package command.version1;

public class AgentInvokerV2 {
    private Command command;

    public AgentInvokerV2() {
        System.out.println("******* agent 2 implementation *********");
    }

    public void setOrder(Command command){
        this.command=command;
    }
    public void placeOrder(){
        if(null!=command) {
            command.execute();
            command=null;
        }
        else
            System.out.println("no order found!");
    }
}
