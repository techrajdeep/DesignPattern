package command.version1;
// agent takes the command and executes the command
public class AgentInvoker {
    private Command command;

    public AgentInvoker(Command command) {
        System.out.println("******* agent 1 implementation *********");
        this.command=command;
    }
    public void placeOrder(){
        this.command.execute();
    }
}
