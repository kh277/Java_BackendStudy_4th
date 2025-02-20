package View;

import java.util.Scanner;

public class InputView
{
    private static Scanner sc = new Scanner(System.in);

    public static int getLadderWidth()
    {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        int ladderWidth = sc.nextInt();

        if (ladderWidth <= 0)
            throw new IllegalArgumentException("사다리의 넓이는 1 이상이어야 합니다.");

        return ladderWidth;
    }

    public static int getLadderHeight()
    {
        System.out.println("\n사다리의 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();

        if (ladderHeight <= 0)
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");

        return ladderHeight;
    }
}
