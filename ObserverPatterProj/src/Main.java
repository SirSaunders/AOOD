import v2.Tests.Test;

public class Main {
    public static void main(String[] args) {
        // go to testing methods to find out how to add observables and observers
        System.out.println("Testing V1");
        v1.ObserverManager.Tests.Test.start_test();
        System.out.println("Testing V2");
        Test.start_test();

    }
}
