import java.util.Random;

public class diceroll {

    int totdice = 2, total = 0, roll = 0, i;
    Random ran = new Random();
    {

        for (i = 0; i < totdice; i++) {
            roll = ran.nextInt(6) + 1;
            total = total + roll;

        }
    }

}