package yustmis.study.me.chapter9;

public class App {
    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardion());
        feed.registerObserver(new LeMonde());

        feed.notifyObservers("The queen said her favourite book is Modern Java in Action!");

        System.out.println("============== ");

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        System.out.println("================");
        Product loan = ProductFactory.createProduct("loan");
    }
}
