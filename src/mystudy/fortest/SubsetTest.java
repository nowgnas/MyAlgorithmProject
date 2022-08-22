package mystudy.fortest;

public class SubsetTest {
    static int n;
    static int [] input;
    static boolean [] isSelected;

    public static void main(String[] args) {

        input = new int[]{1, 2, 3, 4, 5};
        n = input.length;

        isSelected = new boolean[input.length];


    }
    static void subset(int index){
        if (index == n){
            return;
        }

        isSelected[index] = true;
        subset(index + 1);
        isSelected[index] = false;
        subset(index + 1);
    }
}
