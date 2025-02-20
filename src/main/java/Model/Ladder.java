package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder
{
    private final List<Line> lines = new ArrayList<>();
    private final LadderSetting setting;

    public Ladder(int ladderWidth, int ladderHeight)
    {
        this.setting = new LadderSetting(ladderWidth, ladderHeight);
    }

    private boolean randomBoolean()
    {
        int randomNumber = (int)(Math.random() + 0.3);
        if (randomNumber == 1)
            return true;

        return false;
    }

    private void addLines(Line leftLine, Line curLine)
    {
        IntStream.range(0, setting.getHeight())
                .filter(curHeight -> !curLine.checkIsConflict(leftLine, curHeight))
                .forEach(curHeight -> curLine.setPoints(curHeight, randomBoolean()));
    }

    public void setAllLadder() {
        // 0번 라인 생성
        Line firstLine = new Line(setting);
        lines.add(firstLine);
        addLines(firstLine, firstLine);

        // 이후 라인 생성 및 설정
        for (int lineNumber = 1; lineNumber < setting.getWidth(); lineNumber++)
        {
            Line newLine = new Line(setting);
            addLines(lines.get(lineNumber - 1), newLine);
            lines.add(newLine);
        }
    }

    // 현재 높이가 curY이고 finalPosition 사다리에 위치할 때, 이동할 수 있는지 여부 체크
    private int moveLadder(int finalPosition, int curY)
    {
        // 왼쪽 체크
        if (finalPosition > 0 && getData(finalPosition-1, curY))
        {
            finalPosition -= 1;
            return finalPosition;
        }

        // 오른쪽 체크
        if (finalPosition < setting.getWidth() && getData(finalPosition, curY))
        {
            finalPosition += 1;
            return finalPosition;
        }

        return finalPosition;
    }

    public int getFinalPosition(int startPosition)
    {
        int finalPosition = startPosition;
        for (int curY = 0; curY < setting.getHeight(); curY++)
            finalPosition = moveLadder(finalPosition, curY);

        return finalPosition;
    }

    public int getWidth()
    {
        return setting.getWidth();
    }

    public int getHeight()
    {
        return setting.getHeight();
    }

    public boolean getData(int ladderNumber, int ladderHeight)
    {
        return lines.get(ladderNumber).getPoints(ladderHeight);
    }
}
