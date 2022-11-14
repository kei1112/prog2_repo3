package jp.ac.ryukyu.ie.e225718;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public String getName(){
        return this.name;
    }
    public void setName(String heroname){
        this.name = heroname;
    }

    public int getHitPoint(){
        return this.hitPoint;
    }
    public void setHitPoint(int maximumHP){
        this.hitPoint = maximumHP;
    }

    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    public boolean isDead(){
        return this.dead;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        setName(name);
        setHitPoint(maximumHP);
        setAttack(attack);
        setDead(false);
        //this.name = name;
        //this.hitPoint = maximumHP;
        //this.attack = attack;
        //this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", getName(), getHitPoint(), attack);
    }

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * getAttack());
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        setHitPoint((int)(getHitPoint() - damage));
        

        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }



}