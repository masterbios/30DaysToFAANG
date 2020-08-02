import Day07_TwoPointers.FindKClosestElementsGivenValue;

public class Main {
    public static void main(String[] args) {
        int a[] = {12, 16, 22, 30, 35, 35, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int x = 35, k = 4;
        FindKClosestElementsGivenValue obj = new FindKClosestElementsGivenValue();
        obj.solve(a, x, k);
    }

}
