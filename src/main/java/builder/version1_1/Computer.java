package builder.version1_1;

public class Computer extends Object{
    // Optional param
    private  String HDD;
    private  String RAM;
    private  String CPU;
    private  boolean isGraphicsCardEnabled;
    private  boolean isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public void setGraphicsCardEnabled(boolean graphicsCardEnabled) {
        isGraphicsCardEnabled = graphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public void setBluetoothEnabled(boolean bluetoothEnabled) {
        isBluetoothEnabled = bluetoothEnabled;
    }

    public Computer(Builder builder) {
        HDD = builder.HDD;
        RAM = builder.RAM;
        CPU = builder.CPU;
        isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static Builder builder(){
        return new Builder();
    }
    @Override
    public String toString() {
        return super.toString()+"Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", CPU='" + CPU + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    public static class Builder{
        private  String HDD;
        private  String RAM;
        private  String CPU;
        private  boolean isGraphicsCardEnabled;
        private  boolean isBluetoothEnabled;

        public Builder setHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled=isGraphicsCardEnabled;
            return this;
        }
        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled=isBluetoothEnabled;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }

    }


}
