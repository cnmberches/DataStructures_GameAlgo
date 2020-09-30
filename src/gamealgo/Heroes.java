package gamealgo;
public class Heroes
{
    private String heroName = "";    
    private String heroTalk = "";
    private String ability[] = new String[3];
    private int healthPoints = 0;
    private int damage[] = new int[3];
    
    Heroes(String heroName, String heroTalk, String[]ability, int healthPoints, int damage[])
    {
        this.heroName = heroName;
        this.heroTalk = heroTalk;
        this.ability = ability;
        this.healthPoints = healthPoints;
        this.damage = damage;
    }
    
    void setHeroTalk(String heroTalk)
    {
        this.heroTalk = heroTalk;
    }
    
    String getHeroTalk()
    {
        return this.heroTalk;
    }
    
    void useAbility(int abilityNumber, int abilityDamage, Heroes opponent)
    {
        System.out.println(" used " + this.ability [0]);
        opponent.healthPoints -= abilityDamage;
    }
    
    void setHealthPoints(int healthPoints)
    {
        this.healthPoints = healthPoints;
    }
    
    int getHealthPoints()
    {
        return this.healthPoints;
    }
    
    void setHeroName(String heroName)
    {
        this.heroName = heroName;
    }
    
    String getHeroName()
    {
        return this.heroName;
    }
    
    void setFirstAbilityName(String abilityName1)
    {
        this.ability[0] = abilityName1;
    }
    
    String getFirstAbilityName()
    {
        return this.ability[0];
    }
    
    void setSecondAbilityName(String abilityName2)
    {
        this.ability[1] = abilityName2;
    }
    
    String getSecondAbilityName()
    {
        return this.ability[1];
    }
    
    void setThirdAbilityName(String abilityName3)
    {
        this.ability[2] = abilityName3;
    }
    
    String getThirdAbilityName()
    {
        return this.ability[2];
    }
    
    void setFirstAbilityDamage(int AbilityDamage1)
    {
        this.damage[0] = AbilityDamage1;
    }
    
    int getFirstAbilityDamage()
    {
        return this.damage[0];
    }
    
    void setSecondAbilityDamage(int AbilityDamage2)
    {
        this.damage[1] = AbilityDamage2;
    }
    
    int getSecondAbilityDamage()
    {
        return this.damage[1];
    }
    
    void setThirdAbilityDamage(int AbilityDamage3)
    {
        this.damage[2] = AbilityDamage3;
    }
    
    int getThirdAbilityDamage()
    {
        return this.damage[2];
    }
}
