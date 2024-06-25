package builder.version1;

public class ComputerClient {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("2GB", "2TB", "Intel i7").build();
        System.out.println("computer->"+computer);
        Computer computer1 = new Computer.Builder("2GB", "2TB", "Intel i7").setGraphicsCardEnabled(true).build();
        System.out.println("computer1->"+computer1);
        Computer computer2 = new ComputerBuilderDirector().getBasicComputer();
        System.out.println("director computer2->"+computer2);
        Computer computer3 = new ComputerBuilderDirector().getBasicComputer();
        System.out.println("director  computer3->"+computer3);

    }
}
