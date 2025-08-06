package entities;

public class Warrior extends StandardHero {

	public Warrior(String name, Integer defense, Integer damage, Integer HP) {
		super(name, defense, damage, HP);
	}

	public void hability(StandardHero target) {
		Integer attack = target.getDefense();
		attack -= getDamage() * 2;
		target.setDefense(attack);
		if (attack > 0) {
			target.receiveDamage(attack);
		}
		;
	}

	@Override
	public String toString() {
		return "Class: Warrior\nName: " + getName() + "\nDefense: " + getDefense() + "\nDamage: " + getDamage()
				+ "\nHP: " + getHP();
	}
}
