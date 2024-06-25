package builder.version1_1;

public class ComputerClient {
    public static void main(String[] args) {
        Computer computer =  Computer.builder().build();
        System.out.println("computer->"+computer);
        Computer computer1 =  Computer.builder().setCPU("CPU").setRAM("RAM").build();
        System.out.println("computer1->"+computer1);
    }
}
