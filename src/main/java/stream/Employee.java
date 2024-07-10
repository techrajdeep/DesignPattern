package stream;
public class Employee{
    private final String name;
    private final int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
    }
    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public static class  Builder{
        private String name;
        private int id;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
}