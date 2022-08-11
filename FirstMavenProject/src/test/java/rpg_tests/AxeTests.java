package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    @Test
    public void weaponAttacksLosesDurability(){
        Axe axe = new Axe(10,10);
        Dummy dummy = Mockito.mock(Dummy.class);

        axe.attack(dummy);

        Mockito.verify(dummy, Mockito.times(1)).takeAttack(Mockito.anyInt());
        Assert.assertEquals(9,axe.getDurabilityPoints());
    }

    @Test
    public void brokenWeaponCantAttack(){
        Axe axe = new Axe(10,1);
        Dummy dummy = Mockito.mock(Dummy.class);

        IllegalStateException exception = Assert.assertThrows(
                IllegalStateException.class, () -> {
                    axe.attack(dummy);
                    axe.attack(dummy);
                });
        Assert.assertEquals("Axe is broken.", exception.getMessage());

    }
}
