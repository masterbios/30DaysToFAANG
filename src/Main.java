import Day07_TwoPointers.FindKClosestElementsGivenValue;
import Day13_StackAndQueue.InfixToPostfix;

public class Main {
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        InfixToPostfix obj = new InfixToPostfix();
        obj.solve(s);
    }

}
