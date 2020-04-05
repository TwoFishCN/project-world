package com.project.world.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class RadiantAndDire {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue = new LinkedList<>();

        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                queue.add(1);
            } else {
                queue.add(0);
            }
        }

        int radiantBan = 0;
        int direBan = 0;

        int currentPerson;

        while (!queue.isEmpty() && queue.size() > 1) {
            currentPerson = queue.size();

            if (currentPerson <= radiantBan || currentPerson <= direBan) {
                break;
            }

            for (int i = 0; i < currentPerson; i++) {
                Integer poll = queue.poll();
                if (poll.equals(1)) {
                    if (radiantBan > 0) {
                        radiantBan--;
                    } else {
                        direBan++;
                        queue.add(poll);
                    }
                } else {
                    if (direBan > 0) {
                        direBan--;
                    } else {
                        radiantBan++;
                        queue.add(poll);
                    }
                }
            }

        }


        if (queue.size() == 1) {
            Integer poll = queue.poll();
            if (poll == 1) {
                return "Radiant";
            } else {
                return "Dire";
            }
        }

        if (radiantBan > direBan) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    public static void main(String[] args) {
        String rd = new RadiantAndDire().predictPartyVictory("RRR");
        System.out.println(rd);
    }
}
