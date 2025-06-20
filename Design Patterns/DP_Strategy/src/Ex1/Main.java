package Ex1;

public class Main {
    public static void main(String[] args) {

//        Ex_01.RangedAttackStrategy ras = new Ex_01.RangedAttackStrategy();
//        Ex_01.Hero itachi = new Ex_01.Hero("Joaquim",100,20,ras);

        Hero itachi = new Hero("Uchiha",100,20, new RangedAttackStrategy());

        itachi.attack();
        itachi.attack();

        itachi.setFormaAtaque(new MagicAttackStrategy());

        itachi.attack();

        itachi.setFormaAtaque(new SilentAttackStrategy());

        itachi.attack();
    }
}