package yustmis.study.me.chapter9;

public class NYTimes implements Observer{

    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        } 
        // else {
        //     System.out.println("print nothing");
        // }
    }
    
}

class Guardion implements Observer {

    @Override
    public void notify(String tweet) {
        if ( tweet != null && tweet.contains("queen")) {
            System.out.println("Yet more news from London .... " + tweet);
        }
        //  else {
        //     System.out.println("print nothing");
        // }

    }

}

class LeMonde implements Observer {

    @Override
    public void notify(String tweet) {
        if ( tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        } 
        // else {
        //     System.out.println("print nothing");
        // }
    }

}

