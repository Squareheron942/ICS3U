uesses still not yet won then lose
            if (won) {
                System.out.println(winMessages[lineNum]);
                points += winPoints[lineNum];
                System.out.println("Your points: " + points);
                won = false;
            } else {
                System.out.println("You Lost!");
                points += winPoints[6];
                System.out.println("Your points: " + points);
            }
        } while (!canceled());
