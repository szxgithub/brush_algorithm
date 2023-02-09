package middle;

import java.util.HashMap;
import java.util.Map;

public class Item1797 {

    /*

    设计一个验证系统

     */

    class AuthenticationManager {

        // 设置过期时间
        private int timeToLive;

        private HashMap<String,Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            this.map.put(tokenId,currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.getOrDefault(tokenId, 0) > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count =0;
            for (Integer value : map.values()){
                if (value > currentTime){
                    count++;
                }
            }
            return count;
        }
    }

}
