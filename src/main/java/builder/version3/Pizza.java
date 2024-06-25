package builder.version3;
/* "Product" */
public class Pizza {
    public static final String EMPTY = "";
    private String dough = EMPTY;
    private String sauce = EMPTY;
    private String topping = EMPTY;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
