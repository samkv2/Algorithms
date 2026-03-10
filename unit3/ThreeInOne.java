public class ThreeInOne {

    int[] arr = new int[12];

    int top1 = -1;
    int top2 = 3;
    int top3 = 7;

    /* ---------- PUSH OPERATIONS ---------- */

    void push1(int value) {
        if (top1 == 3) {
            System.out.println("Stack1 Overflow");
            return;
        }

        arr[++top1] = value;
    }

    void push2(int value) {
        if (top2 == 7) {
            System.out.println("Stack2 Overflow");
            return;
        }

        arr[++top2] = value;
    }

    void push3(int value) {
        if (top3 == 11) {
            System.out.println("Stack3 Overflow");
            return;
        }

        arr[++top3] = value;
    }

    // ---------- POP OPERATIONS ---------- 

    int pop1() {
        if (top1 < 0) {
            System.out.println("Stack1 Underflow");
            return -1;
        }

        return arr[top1--];
    }

    int pop2() {
        if (top2 < 4) {
            System.out.println("Stack2 Underflow");
            return -1;
        }

        return arr[top2--];
    }

    int pop3() {
        if (top3 < 8) {
            System.out.println("Stack3 Underflow");
            return -1;
        }

        return arr[top3--];
    }

    // ---------- PRINT STACKS ---------- 

    void printStacks() {

        System.out.println("Stack1:");
        for (int i = 0; i <= top1; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.println("Stack2:");
        for (int i = 4; i <= top2; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.println("Stack3:");
        for (int i = 8; i <= top3; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // ---------- MAIN ---------- 

    public static void main(String[] args) {

        ThreeInOne stack = new ThreeInOne();

        stack.push1(10);
        stack.push1(20);

        stack.push2(50);
        stack.push2(60);

        stack.push3(100);

        stack.printStacks();

        System.out.println("Pop Stack1: " + stack.pop1());
        System.out.println("Pop Stack2: " + stack.pop2());
        System.out.println("Pop Stack3: " + stack.pop3());

        stack.printStacks();
    }
}
