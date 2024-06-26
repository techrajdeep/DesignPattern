#### [gfg](https://www.geeksforgeeks.org/command-pattern/)
#### [oodesign](https://www.oodesign.com/command-pattern)
#### [text editor exmaple](https://refactoring.guru/design-patterns/command/java/example)
#### [interesting example](https://java-design-patterns.com/patterns/command/#programmatic-example-of-command-pattern-in-java)
#### [another good example](https://www.digitalocean.com/community/tutorials/command-design-pattern)

## TODO : undo / redo - used mostly using command pattern

```
Actors:
i) Command - declares an interface for executing an operation;
ii) ConcreteCommand - extends the Command interface, implementing the Execute method by invoking 
 the corresponding operations on Receiver. It defines a link between the Receiver and the action.
iii) Client - creates a ConcreteCommand object and sets its receiver;
iv) Invoker - asks the command to carry out the request;
v) Receiver - knows how to perform the operations;
```
```
Client calls Invoker => Invoker calls ConcreteCommand => ConcreteCommand calls Receiver method, 
which implements abstract Command method.
```
Example:

```
public interface Order {
    public abstract void execute ( );
}

// Receiver class.
class StockTrade {
    public void buy() {
        System.out.println("You want to buy stocks");
    }
    public void sell() {
        System.out.println("You want to sell stocks ");
    }
}

// Invoker.
class Agent {
    private m_ordersQueue = new ArrayList();

    public Agent() {
    }
    
    void placeOrder(Order order) {
        ordersQueue.addLast(order);
        order.execute(ordersQueue.getFirstAndRemove());
    }    
}

//ConcreteCommand Class.
class BuyStockOrder implements Order {
    private StockTrade stock;
    public BuyStockOrder ( StockTrade st) {
        stock = st;
    }
    public void execute( ) {
        stock . buy( );
    }
}

//ConcreteCommand Class.
class SellStockOrder implements Order {
    private StockTrade stock;
    public SellStockOrder ( StockTrade st) {
        stock = st;
    }
    public void execute( ) {
        stock . sell( );
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        StockTrade stock = new StockTrade();
        BuyStockOrder bsc = new BuyStockOrder (stock);
        SellStockOrder ssc = new SellStockOrder (stock);
        Agent agent = new Agent();

        agent.placeOrder(bsc); // Buy Shares
        agent.placeOrder(ssc); // Sell Shares
    }
}
```


```
interface Command {
    void execute();
}
interface Receiver {
    public  void switchOn();
       
}
class OnCommand implements Command{
    private Receiver receiver;

    public OnCommand(Receiver receiver){
        this.receiver = receiver;
    }
    public void execute(){
        receiver.switchOn();
    }
}
class Invoker {
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }
    public void execute(){
        this.command.execute();
    }
}

class TV implements Receiver{

     public void switchOn(){
        System.out.println("Switch on from TV");
    }
}
class DVDPlayer implements Receiver{

    public void switchOn(){
         System.out.println("Switch on from DVDPlayer");
    }
}

public class CommandDemoEx{
    public static void main(String args[]){
        // On command for TV with same invoker 
        Receiver receiver = new TV();
        Command onCommand = new OnCommand(receiver);
        Invoker invoker = new Invoker(onCommand);
        invoker.execute();

        // On command for DVDPlayer with same invoker 
        receiver = new DVDPlayer();
        onCommand = new OnCommand(receiver);
        invoker = new Invoker(onCommand);
        invoker.execute();            
    }
}
```

Another Example

```
interface Command {
  public void execute();
  public void unexecute();
}
class AddToCartCommand implements Command {
    public void execute (){
        // Insert row in the cart table
    }
    public void unexecute (){
        // Delete row from the cart table
    }
}

class PaymentCommand implements Command {
    public void execute (){
        // Insert row in the payments table
    }
    public void unexecute (){
        // Delete row from the payments table
    }
}

class CreateOrderCommand implements Command {
    public void execute (){
        // Insert row in the order table
    }
    public void unexecute (){
        // Delete row from the order table
    }
}

class SendToLogisticsCommand implements Command {
    public void execute (){
        // Insert into logistics table
    }
    public void unexecute (){
        // Delete from the logistics table
    }
}

class DispatchCommand implements Command {
    public void execute (){
        // Insert into Dispatch table
    }
    public void unexecute (){
        // Delete from the Dispatch table
    }
}
class Invoker {
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }
    public void executeCommand(){
        this.command.execute();
    }
    public void unexecuteCommand(){
        this.command.unexecute();
    }
}
public class CommandPatternDemo {
    public static void main (String args[]){
        // Stores history of commands so that we can reverse the transactions
        // or go back to the previous state of the applicaion.
        Stack<Command> commandHistory = new Stack<Command>();
        // If add to cart api called
        Command command = new AddToCartCommand();
        Invoker invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If payment api called
        command = new PaymentCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If order creation api called
        command = new CreateOrderCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If send logistics api called
        command = new SendToLogisticsCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If dispath api called
        command = new DispatchCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);
    }
}

```

When to use it?
i) when we a have series of transactional behavior and there can be a possibility where we want to 
move back to the previous state that time this pattern can be a massively powerful tool.
ii) Decouple the execution logic of the command from the invoker.

