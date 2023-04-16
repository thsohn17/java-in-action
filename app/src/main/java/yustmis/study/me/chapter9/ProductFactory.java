package yustmis.study.me.chapter9;

public class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }
}

class Loan extends Product{
    // private String name;
}

class Stock extends Product{
    // private String name;
}

class Bond extends Product{
    // private String name;
}

class Product {
    private String name;
}
