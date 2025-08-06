package entities;

public class Wizard extends StandardHero {

	public Wizard(String name, Integer defense, Integer damage, Integer HP) {
		super(name, defense, damage, HP);
	}

	public void hability(StandardHero target) {
		Integer life = target.getHP();
		life -= getDamage() + 5;
		target.setHP(life);
		if (life > 0) {
			target.receiveDamage(life);
		}
	}

	@Override
	public String toString() {
		return "Class: Wizard\nName: " + getName() + "\nDefense: " + getDefense() + "\nDamage: " + getDamage()
				+ "\nHP: " + getHP();
	}
}
