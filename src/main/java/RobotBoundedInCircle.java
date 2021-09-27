public class RobotBoundedInCircle {



    public static void main(String[] args) {
        RobotBoundedInCircle robotBoundedInCircle = new RobotBoundedInCircle();

        System.out.println(robotBoundedInCircle.isRobotBounded("GL"));
        //23:51
    }

    private int[] coordinate = new int[]{0, 0};
    private char direction = 'N';


    public boolean isRobotBounded(String instructions) {
        instructions = instructions + instructions + instructions + instructions;

        char[] instructionArray = instructions.toCharArray();

        for (Character c : instructionArray) {
            if (c == 'G') {
                if (direction == 'N') {
                    coordinate[1] = coordinate[1] + 1;
                }
                if (direction == 'S') {
                    coordinate[1] = coordinate[1] - 1;
                }
                if (direction == 'E') {
                    coordinate[0] = coordinate[0] + 1;
                }
                if (direction == 'W') {
                    coordinate[0] = coordinate[0] - 1;
                }
            }
            if (c == 'L') {
                if (direction == 'N') {
                    direction = 'W';
                } else if (direction == 'S') {
                    direction = 'E';
                } else if (direction == 'E') {
                    direction = 'N';
                } else if (direction == 'W') {
                    direction = 'S';
                }
            }

            if (c == 'R') {
                if (direction == 'N') {
                    direction = 'E';
                } else if (direction == 'S') {
                    direction = 'W';
                } else if (direction == 'E') {
                    direction = 'S';
                } else if (direction == 'W') {
                    direction = 'N';
                }


            }


        }
        return coordinate[1] == 0 && coordinate[0] == 0;
    }

}
