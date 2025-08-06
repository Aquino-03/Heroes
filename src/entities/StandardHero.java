package entities;

public abstract class StandardHero {

	private String name;
	private Integer defense;
	private Integer damage;
	private Integer HP;

	public StandardHero(String name, Integer defense, Integer damage, Integer HP) {
		this.name = name;
		this.defense = defense;
		this.damage = damage;
		this.HP = HP;
	}

	public StandardHero() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getHP() {
		return HP;
	}

	public void setHP(Integer hP) {
		HP = hP;
	}

	@Override
	public String toString() {
		return "StandardHero name=" + name + " defense=" + defense + ", damage=" + damage + ", HP=" + HP;
	}

	public void Attack(StandardHero target) {
		System.out.println("-> " + this.name + " attack " + target.getName() + "!");

		int damageToDeal = this.damage - target.getDefense();
		if (damageToDeal < 0) {
			damageToDeal = 0;
		}

		target.receiveDamage(damageToDeal);
	}

	public void receiveDamage(int damageReceived) {
		this.HP -= damageReceived;

		if (this.HP > 0) {
			System.out.println("   " + this.name + " received " + damageReceived + " of damage");
		} else {
			this.HP = 0;
			System.out.println("   " + this.name + " received " + damageReceived + " of damage");
		}
	}

	public boolean beAlive() {
		return this.HP > 0;
	}

	public abstract void hability(StandardHero target);

}
