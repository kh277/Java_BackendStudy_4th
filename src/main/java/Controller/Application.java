package Controller;

import Model.Ladder;
import View.ResultView;

public class Application
{
    public static void main(String[] args)
    {
        int ladderWidth = 4;
        int ladderHeight = 4;
        Ladder ladder = new Ladder(ladderWidth, ladderHeight);
        ladder.setAllLadder();

        ResultView.printLadder(ladder);
    }
}
