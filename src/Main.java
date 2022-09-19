public class Main {
    public static void main(String[] args) {
     Solution s = new Solution();
      String probarec1 = "baoollnnololgbax";
      String probarec2 = "baonxxoll";
      String probarec3 = "aleksabaool";
      int proba1 = Solution.maximalniBrojBalona(probarec1.toUpperCase());
      int proba2 = Solution.maximalniBrojBalona(probarec2.toUpperCase());
      int proba3 = Solution.maximalniBrojBalona(probarec3.toUpperCase());
      System.out.println(proba1);
      System.out.println(proba2);
      System.out.println(proba3);
    }
}
