package command.version1;

import java.util.LinkedList;
import java.util.Queue;

public class AgentInvokerV3 {
    Queue<Command> queue;
    public AgentInvokerV3() {
        System.out.println("******* agent 3 implementation *********");
        queue=new LinkedList<>();
    }
    public void placeOrder(Command command){
        if(null!=queue){
            queue.offer(command);
            System.out.println("Order placed , waiting for execution");
        }
    }
    public void execute(){
        while(!queue.isEmpty()){
            Command command = queue.poll();
            command.execute();
            System.out.println("Order executed by Agent 3");
        }
        System.out.println("no order found!!");
    }
}
