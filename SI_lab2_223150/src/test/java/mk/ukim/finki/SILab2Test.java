package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List<Item> items(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    @Test
    void checkEveryBranch() {
        RuntimeException exc;
        //1 фрла Exception и излегува од програмата.
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(exc.getMessage().contains("allItems list can't be null!"));

        //2 (празна листа) ќе падне во for циклусот(4,2): allItems.size() не е поголемо од i=0, sum<=payment.
        assertTrue(SILab2.checkCart(new ArrayList<>(), 0));

        //3 (празна листа)ќе падне во for циклусот(4,2): allItems.size() не е поголемо од i=0, sum>payment.
        assertFalse(SILab2.checkCart(new ArrayList<>(), -1));

        //4 (празен String),index=null.
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("", null, 100, 0.1f)), 100));
        assertTrue(exc.getMessage().contains("No barcode!"));

        //5 баркодот почнува на 0, и цената е над 300.
        assertFalse(SILab2.checkCart(items(new Item("", "0246", 310, 0.1f)), 100));

        //6 баркотот содржи буква и имаме зададено име.
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("Kniga", "2468m", 100, 0.1f)), 100));
        assertTrue(exc.getMessage().contains("Invalid character in item barcode!"));

        //7 вредноста на цената е помала од 300 и попустот има негативна вредност.
        assertFalse(SILab2.checkCart(items(new Item("Kniga", "2468", 200, -1)), 2));
    }

    @Test
    void checkMultipleConditions() {
        //TTF
        assertFalse(SILab2.checkCart(items(new Item("", "2468", 310, 0.2f)), 2));
        //TFX
        assertFalse(SILab2.checkCart(items(new Item("", "2468", 310, -1f)), 2));
        //TTT
        assertTrue(SILab2.checkCart(items(new Item("", "0246", 310, 0.2f)), 300));
        //FXX
        assertFalse(SILab2.checkCart(items(new Item("", "0246", 290, 0.2f)), 2));
    }
}