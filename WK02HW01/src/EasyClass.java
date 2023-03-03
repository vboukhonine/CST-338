public class EasyClass {
    private int count = 0;
    private String name = "";
    private double score = 0;

    EasyClass(String name, double score){
        this.name = name;
        this.score = score;
    }
    EasyClass(String name, int count, double score){
        this.name = name;
        this.count = count;
        this.score = score;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }



}
