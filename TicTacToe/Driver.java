public class Driver {
    public static void main() {
        
        boolean replay = true;
        while (replay) {
            System.out.println("Game Mode:");
            System.out.println("(a) Player vs Player");
            System.out.println("(b) Player vs Computer");
            String b = UserInput.getString();
            
            System.out.println("What size board do you want?");
            System.out.println("(Ex: Enter 3 for 3x3 board)");
            int s = Integer.parseInt(UserInput.getString());
            
            Game a = new Game(s);
            a.printBoard();
            
            boolean ongoing = true;
            while (ongoing) {
                boolean won = false;
                int row;
                if (b.equals("b")) {
                    System.out.println("Your turn: what row do you pick?");
                    row = Integer.parseInt(UserInput.getString());
                }else {
                    System.out.println("Player1's turn: what row do you pick?");
                    row = Integer.parseInt(UserInput.getString());
                }
                
                
                
                
                System.out.println("What column?");
                int col = Integer.parseInt(UserInput.getString());
                a.setO(row, col);
                a.printBoard();
                if (a.checkWin(" O  ")) {
                    if (b.equals("b")) {
                        System.out.println("OK cool, you win.");
                    }else {
                        System.out.println("Player1 wins. Good for you.");
                    }
                    won = true;
                }
                
                if (!won && a.checkFilled()) {
                    System.out.println("Oops, y'all tied.");
                    won = true;
                }
                
                int r = 0;
                int c = 0;
                if (!won) {
                    if (b.equals("b")) {
                        System.out.println("");
                        System.out.println("Computer's turn:");
                        //fix so that it can't put down in places that arent null
                        boolean chosen = false;
                        int c1 = a.checkPosWinRow(" X  ");
                        if (c1 != -1) {
                            c = a.checkColOfRow(c1);
                            if (c != -1) {
                                r = c1;
                                chosen = true;
                                //System.out.println("1");
                            }
                            
                        }
                        
                        if (!chosen) {
                            int c2 = a.checkPosWinCol(" X  ");
                            if (c2 != -1) {
                                r = a.checkRowOfCol(c2);
                                if (r != -1) {
                                    c = c2;
                                    chosen = true;
                                    //System.out.println("2");
                                }
                            }
                        }
                        
                        if (!chosen) {
                            if (a.checkPosWinDiag1(" X  ")) {
                                r = a.getPosWinDiag1();
                                if (r != -1) {
                                    c = r;
                                    chosen = true;
                                    //System.out.println("7");
                                }
                            }
                        }
                        
                        if (!chosen) {
                            if (a.checkPosWinDiag2(" X  ")) {
                                r = a.getPosWinDiag2();
                                if (r != -1) {
                                    c = s - 1 - r;
                                    chosen = true;
                                    //System.out.println("4");
                                }
                            }
                        }
                        
                        if (!chosen) {
                            int c5 = a.checkPosWinRow(" O  ");
                            if (c5 != -1) {
                                c = a.checkColOfRow(c5);
                                if (c != -1) {
                                    r = c5;
                                    chosen = true;
                                    //System.out.println("5");
                                }
                            }
                        }
                        
                        if (!chosen) {
                            int c6 = a.checkPosWinCol(" O  ");
                            if (c6 != -1) {
                                r = a.checkRowOfCol(c6);
                                if (r != -1) {
                                    c = c6;
                                    chosen = true;
                                    //System.out.println("6");
                                }
                            }
                        }
                        
                        if (!chosen) {
                            if (a.checkPosWinDiag1(" O  ")) {
                                r = a.getPosWinDiag1();
                                if (r != -1) {
                                    c = r;
                                    chosen = true;
                                    //System.out.println("7");
                                }
                            }
                        }
                        
                        if (!chosen) {
                            if (a.checkPosWinDiag2(" O  ")) {
                                r = a.getPosWinDiag2();
                                if (r != -1) {
                                    c = s - 1 - r;
                                    chosen = true;
                                    //System.out.println("4");
                                }
                            }
                        }
                        
                        while (!chosen) {
                            r = (int)(Math.random() * a.getBoard().length);
                            c = (int)(Math.random() * a.getBoard().length);
                            if (a.checkAvailable(r, c)) {
                                chosen = true;
                            }
                        }
                    }else {
                        System.out.println("");
                        System.out.println("Player2's turn: what row do you pick?");
                        r = Integer.parseInt(UserInput.getString());
                        System.out.println("What column?");
                        c = Integer.parseInt(UserInput.getString());
                    }
                    a.setX(r, c);
                    a.printBoard();
                    if (a.checkWin(" X  ")) {
                        if (b.equals("b")) {
                            System.out.println("You lost. Oof.");
                        }else {
                            System.out.println("Player2 wins. Yay.");
                        }
                        won = true;
                    }
                }
                
                if (won) {
                    ongoing = false;
                }
            }
            System.out.println("");
            System.out.println("Do you want to play again?");
            System.out.println("(a) Yes");
            System.out.println("(b) No");
            String z = UserInput.getString();
            if (z.equals("b")) {
                replay = false;
            }
        }
        
    }
}