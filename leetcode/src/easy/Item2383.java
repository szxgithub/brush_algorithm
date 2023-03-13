package easy;

public class Item2383 {
    /*
    赢得比赛需要的最少训练时长

     */


    /**
     *
     * @param initialEnergy 初始精力
     * @param initialExperience 初始经验
     * @param energy
     * @param experience
     * @return
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; i++){
            int e = energy[i];
            if (initialEnergy <= e){
                ans += e + 1 - initialEnergy;
                initialEnergy = e + 1;
            }
            initialEnergy -= e;
            e = experience[i];
            if (initialExperience <= e){
                ans += e + 1 - initialExperience;
                initialExperience = e + 1;
            }
            initialExperience += e;
        }
        return ans;
    }

}
