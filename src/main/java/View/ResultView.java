package View;

import Model.Ladder;

import java.util.stream.IntStream;

public class ResultView
{
    // 출력 처리
    private static void getLadderSegment(int x, int y, Ladder ladder)
    {
        if (x % 2 == 0)
        {
            System.out.print("|");
            return;
        }

        if (ladder.getData(x/2, y))
        {
            System.out.print("-----");
            return;
        }

        System.out.print("     ");
    }

    // 가로줄 출력처리
    private static void printRowLadder(int y, Ladder ladder)
    {
        int ladderWidth = ladder.getWidth();

        System.out.print("    ");
        IntStream.range(0, ladderWidth*2+1)
                .forEach(x -> getLadderSegment(x, y, ladder));
        System.out.println();
    }

    // 전체 사다리 출력처리
    public static void printLadder(Ladder ladder)
    {
        System.out.println("\n실행결과");
        IntStream.range(0, ladder.getHeight())
                .forEach(y -> printRowLadder(y, ladder));
    }

    // 시작점, 도착점 출력처리
    public static void printFinalPosition(Ladder ladder)
    {
        System.out.println("\n");
        for (int i = 0; i < ladder.getWidth()+1; i++)
            System.out.printf("%d -> %d\n", i, ladder.getFinalPosition(i));
    }
}
