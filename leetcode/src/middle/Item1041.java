package middle;

public class Item1041 {

    /*
困于环中的机器人
     */

    /*
    模拟

    机器人想要摆脱循环，在一串指令之后的状态，必须是不位于原点且方向朝北。
     */
    public boolean isRobotBounded(String instructions) {
        int[] origi = new int[]{0,0};
        int[] direction = {0,1};

        for (int i = 0; i < instructions.length(); i++){
            char c = instructions.charAt(i);
            if (c == 'G'){
                origi[0] = origi[0] + direction[0];
                origi[1] = origi[1] + direction[1];
            }else if (c == 'L'){
                if (direction[0] == 0 && direction[1] == 1){
                    direction[0] = -1;
                    direction[1] = 0;
                }else if (direction[0] == -1 && direction[1] == 0){
                    direction[0] = 0;
                    direction[1] = -1;
                }else if (direction[0] == 0 && direction[1] ==  -1){
                    direction[0] = 1;
                    direction[1] = 0;
                }else if (direction[0] == 1 && direction[1] == 0){
                    direction[0] = 0;
                    direction[1] = 1;
                }
            }else if (c == 'R'){
                if (direction[0] == 0 && direction[1] == 1){
                    direction[0] = 1;
                    direction[1] = 0;
                }else if (direction[0] == 1 && direction[1] == 0){
                    direction[0] = 0;
                    direction[1] = -1;
                }else if (direction[0] == 0 && direction[1] ==  -1){
                    direction[0] = -1;
                    direction[1] = 0;
                }else if (direction[0] == -1 && direction[1] == 0){
                    direction[0] = 0;
                    direction[1] = 1;
                }
            }
        }

        if (direction[0] == 0 && direction[1] == 1){
            if (origi[0] == 0 && origi[1] == 0){
                return true;
            }else {
                return false;
            }
        }else {
            return true;
        }
    }

    public static void main(String[] args) {

        Item1041 item1041 = new Item1041();
        String instructions = "GL";
        boolean robotBounded = item1041.isRobotBounded(instructions);
        System.out.println(robotBounded);

    }

}
