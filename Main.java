import java.util.*;
public class Main {

    //buat Board sm Turn terlebih Dahulu
    static String[] board;
    static String turn;

    //Buat ChecKWinner
    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> board[0] + board[1] + board[2];
                case 1 -> board[3] + board[4] + board[5];
                case 2 -> board[6] + board[7] + board[8];
                case 3 -> board[0] + board[3] + board[6];
                case 4 -> board[1] + board[4] + board[7];
                case 5 -> board[2] + board[5] + board[8];
                case 6 -> board[0] + board[4] + board[8];
                case 7 -> board[2] + board[4] + board[6];
                default -> null;
            };

            // Buat Return jan Lupa Bos
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        System.out.println(
                turn + " Giliran kamu, Masukkin Angkanya: ");
        return null;
    }

    //Buat Board yang Simple saja
    static void printBoard()
    {
        System.out.println("|-----------|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|-----------|");
    }

    //Buat jalanny Game
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        //Judul Game nya Jan Lupa
        System.out.println("Welcome Tik Tak Toe Nih bos.");
        printBoard();

        //First kita beri X jalan Terlebih Dahulu
        System.out.println(
                "X Jalan Dulu. Masukin Mau Nomer Berapa?");

        while (winner == null) {
            int numInput;

            //Buat jg jika angka tidak masuk diantara 1-9
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input,Masukin Lagi Angka yang Ada");
                    continue;
                }
            }

            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input,Masukin Lagi Angka yang Ada");
                continue;
            }

            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }

            //Kalo Angka Telah Diinput
            else {
                System.out.println(
                        "Lah Ada Isi Slot, Masukkin Angka yang Lain");
            }
        }

        //Jika Tidak Terdapat Pemenang
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "Draw Bos, Terima Kasih Telah Bermain");
        }

        //Untuk Jika ada Pemenang
        else {
            System.out.println(
                    "GGWP " + winner
                            + "'s MENANG, Terima Kasih Telah Bermain");
        }
        in.close();
    }
}
