package org.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.objects.Member;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Member> members = new ArrayList<>();

        System.out.println("Witamy w programie losującym. Proszę podać imię członka do losowania.");

        Scanner in = new Scanner(System.in);
        String input = in.next();

        //adding members
        while (!input.equals(("losowanie")))
        {
            members.add(new Member(input));

            System.out.println("Aktualni członkowie to:" + members);
            System.out.println(
                "Proszę podać kolejne imię członka do losowania. Jeżeli chcesz przejść do losowania wpisz losowanie" + "\"losowanie\".");

            input = in.next();
        }

        int upperBound = members.size();
        Member[][] pairedMembers;

        //draw
        System.out.println("Uwaga, przeprowadzam losowanie!");
        Collections.shuffle(members);

        pairedMembers = new Member[upperBound][2];

        int memberNo;
        int i = 0;
        int j = 1;
        int pairNo = 0;

        for (memberNo = 0; memberNo < members.size(); memberNo++)
        {
            pairedMembers[pairNo][i] = members.get(pairNo);
            pairNo++;
        }

        pairNo = 0;

        for (memberNo = 1; memberNo < members.size(); memberNo++)
        {
            pairedMembers[pairNo][j] = members.get(memberNo);
            pairNo++;
        }
        {
            pairedMembers[members.size() - 1][j] = members.get(0);
        }

        //Result of the lottery
        System.out.println("Losowanie przebiegło pomyślnie. Oto wyniki:");
        System.out.println(Arrays.deepToString(pairedMembers));

    }
}
