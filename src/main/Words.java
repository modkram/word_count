package main;

/**
 * Created by Modkram on 30.09.2017.
 */
public class Words {

    private String word;
    private int count;

    public Words(){}

    public Words(String word, int count){
        this.word = word;
        this.count = count;
    }

    public String getWord(){
        return this.word;
    }

    public int getCount() {
        return count;
    }

    public void addCount(){
        this.count++;
    }

    public String toString(){
        return word + "=" + count;
    }



}
