import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            int numOfMonth;
            int numOfDay;
            String name;
            String position;
            Scanner scanner = new Scanner(System.in);

            System.out.println("-------------- Welcome to Doctor Page! ---------------");
            System.out.print("-> Enter Your Name : ");
            name = scanner.next();
            System.out.print("-> Enter Your Position : ");
            position = scanner.next();
            System.out.print("-> Enter Number Of the Month : ");
            numOfMonth = scanner.nextInt();
            System.out.print("-> Enter Number of Day : ");
            numOfDay = scanner.nextInt();

            int[][] Doc = new int[numOfMonth][numOfDay];
            for (int i = 0; i < numOfMonth; i++) {
                for (int j = 0; j < numOfDay; j++) {
                    Doc[i][j] = 1;
                }
            }

            while(true) {
                System.out.println("\n========================Doctor Appointment Scheduler System==========================");
                System.out.println("\n1- Check Doctor");
                System.out.println("2- Booking Doctor");
                System.out.println("3- Cancel Doctor");
                System.out.println("4- reset Doctor");
                System.out.println("5- Exit");

                System.out.println("------------------------------------------------------------------------");

                System.out.print("Choose Option (1-5) :");
                int option = scanner.nextInt();

                switch (option){
                    case 1:

                        System.out.println("-------------- Display All Doctor Information---------------");

                        System.out.println("ID\t\tName\t\tPosition\t\tAvailable\t\tUnavailable");

                        for (int i = 0; i < numOfMonth; i++) {
                            int availableDay = 0,unavailableDay=0;
                            for (int j = 0; j < numOfDay; j++) {
                                if(Doc[i][j] == 1){
                                    availableDay++;
                                } else if (Doc[i][j] == 0) {
                                    unavailableDay++;
                                }
                            }
                            System.out.println((i+1)+"\t\t"+name+"\t\t"+position+"\t\t\t\t"+availableDay +"\t\t\t\t"+unavailableDay);
                        }
                        // Display Day
                        System.out.print("Enter 0 to back or Doctor ID to see the detail :");
                        int DocIDD = scanner.nextInt();

                        System.out.println("-------------------Display Month Information-----------------------");
                        System.out.println();


                        if(DocIDD == 0){
                            break;
                        } else {
                            int availableDay = 0;
                            int unavailableDay = 0;
                            for(int i=0;i<Doc[DocIDD-1].length;i++){
                                if ((Doc[DocIDD-1][i] == 1 )){
                                    System.out.print("(+)"+(i+1)+"\t");
                                }else {
                                    System.out.print("(-)"+(i+1)+"\t");
                                }
                                if((i +1) % 5 == 0) {
                                    System.out.println();
                                }
                                if(Doc[DocIDD - 1][i] == 1){
                                    availableDay++;
                                } else if (Doc[DocIDD - 1][i] == 0) {
                                    unavailableDay++;
                                }
                            }
                            System.out.println();
                            System.out.println("(-) : Unavailable"+"(" +unavailableDay+ ")"+"\t\t(+) : Available"+"(" +availableDay+ ")");

                        }
                        break;
                    case 2:
                        System.out.print("Enter Doctor ID: ");
                        int Docid = scanner.nextInt();
                        int availableDay = 0;
                        int unavailableDay = 0;

                        // Display current day status

                        for (int i = 0; i < Doc[Docid - 1].length; i++) {
                            if((Doc[Docid - 1][i] == 1)){
                                System.out.print("(+)"+(i+1)+"\t");
                            }else {
                                System.out.print("(-)"+(i+1)+"\t");
                            }
                            if ((i + 1) % 5 == 0) {
                                System.out.println();
                            }
                            if (Doc[Docid - 1][i] == 1) {
                                availableDay++;
                            } else if (Doc[Docid - 1][i] == 0) {
                                unavailableDay++;
                            }
                        }

                        System.out.println();
                        System.out.println("(-) : Unavailable" + "(" + unavailableDay + ")" + "\t\t(+) : Available" + "(" + availableDay + ")");

                        System.out.print("Enter Day for booking: ");
                        int day = scanner.nextInt();

                        if (Doc[Docid - 1][day - 1] == 1) {
                            System.out.print("Do you want to book day number " + day + "? (y/n): ");
                            String dayNum = scanner.next();
                            System.out.println(dayNum);

                            if (dayNum.equals("y")||dayNum.equals("Y")) {
                                Doc[Docid - 1][day - 1] = 0;
                                System.out.println("Day Number " + day + " was booked successfully!");
                            } else if (dayNum.equals("n") || dayNum.equals("N")) {
                                System.out.println("Day number " + day + " was declined!");
                            } else {
                                System.out.println("Please input 'y' or 'n'!");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Enter Doctor ID: ");
                        int cancelDocid = scanner.nextInt();

                        System.out.println("--------------- Display Doctor Information ---------------");
                        System.out.println();

                        int availableDayCancel = 0;
                        int unavailableDayCancel = 0;

                        for (int i = 0; i < Doc[cancelDocid - 1].length; i++) {
                            if((Doc[cancelDocid - 1][i] == 1)){
                                System.out.println("(+)"+(i+1)+"\t");
                            }else {
                                System.out.println("(-)"+(i+1)+"\t");
                            }
                            if ((i + 1) % 5 == 0) {
                                System.out.println();
                            }
                            if (Doc[cancelDocid - 1][i] == 1) {
                                availableDayCancel++;
                            } else if (Doc[cancelDocid - 1][i] == 0) {
                                unavailableDayCancel++;
                            }
                        }

                        System.out.println();
                        System.out.println("(-) : Unavailable" + "(" + unavailableDayCancel + ")" + "\t\t(+) : Available" + "(" + availableDayCancel + ")");

                        System.out.print("Enter Day for cancellation: ");
                        int cancelday = scanner.nextInt();

                        if (Doc[cancelDocid - 1][cancelday - 1] == 0) {
                            Doc[cancelDocid - 1][cancelday - 1] = 1;
                            System.out.println("Booking for seat Number " + cancelday + " was canceled successfully!");
                        } else {
                            System.out.println("seat number " + cancelday + " is not booked!");
                        }
                        break;
                    case 4:
                        System.out.print("Choose Doctor ID: ");
                        int reDocid = scanner.nextInt();

                        for (int i = 0; i < Doc[reDocid - 1].length; i++) {
                            Doc[reDocid - 1][i] = 1;
                        }

                        System.out.println("All seats in the bus were rested successfully!");
                        break;
                    case 5:
                        System.out.println("Good Bye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please Input from 1 to 5!");
                }
            }
        }
    }