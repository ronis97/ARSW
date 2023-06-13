package edu.escuelaing.arsw.picasyfamas.Entities;

public class Game {
    private Integer picas;
    private Integer famas;
    private Integer randomNumber;
    private Integer number;
    private Integer attempts;
    private Integer digits;
    private boolean state;


    public Game(){
        picas = 0;
        famas = 0;
        number = 0;
        randomNumber = 0;
        attempts = 10;
        state = true;
    }

    public void prepareRandomNumber(){
        if(randomNumber == 0){
            int minRange = (int)Math.pow(10,getDigits()-1);
            int maxRange = (int)Math.pow(10,getDigits())-1;
            setRandomNumber((int) (Math.random()*((maxRange+1)-minRange))+minRange);
        }
    }

    public boolean playing(){
        String num = getNumber().toString();
        String guess = getRandomNumber().toString();
        picas = 0;
        famas = 0;
        if(attempts != 0) {
            calculatePicas(guess, num);
            calculateFamas(guess, num);
            if (picas == num.length() && famas == num.length()) {
                return true;
            }
            else {
                attempts--;
                return false;
            }
        }
        else {
            state = false;
            return false;
        }
    }

    public void calculatePicas(String guess,String num){
        for(char i:num.toCharArray()){
            if(guess.contains(String.valueOf(i))){
                this.picas+=1;
            }
        }
    }

    public void calculateFamas(String guess,String num){
        char[] guessArray = guess.toCharArray();
        char[] numArray = num.toCharArray();
        for(int i=0; i<numArray.length;i++){
            if(guessArray[i] == numArray[i]){
                this.famas+=1;
            }
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Integer getPicas() {
        return picas;
    }

    public void setPicas(Integer picas) {
        this.picas = picas;
    }

    public Integer getFamas() {
        return famas;
    }

    public void setFamas(Integer famas) {
        this.famas = famas;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

}
