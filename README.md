## Мелани Додевска 223150

### Control Flow Graph
Предикатните јазли се обоени во зелено.
![Untitled Diagram drawio (3)](https://github.com/melanidodevska/SI_2024_lab2_223150/assets/164401799/270ccfd9-d939-46d2-9c87-bb68f227e61a)

### Цикломатска комплексност
Цикломатската комплексност е 10, ја добив броејќи ги предикатните  јазли. Со формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.

### Tест случаи според Every Branch критериумот:

1. allItems=null,payment=100 - 1->2->27-фрла Exception и излегува од програмата.
2. allItems=[],payment=0 - 1->3->4.1->4.2->23->24->27-(празна листа) ќе падне во for циклусот(4,2): allItems.size() не е поголемо од i=0, sum<=payment.
3. allItems=[],payment=-1 - 1->3->4.1->4.2->23->25->26->27-(празна листа)ќе падне во for циклусот(4,2): allItems.size() не е поголемо од i=0, sum>payment.
4. allItems = [new Item("", "null", 100, 0.1f)], payment = 100 - 1->3->4.1->4.2->5->6->7->8->19->20->27-(празен String),index=null.
5. allItem = [new Item("", "0246", 310, 0.1f)], payment=100 - 1->3->4.1->4.2->5->6->7->8->9->10->11.1->11.2->12->13->11.11.3->11.2->15->16->21->22->4.3->4.2->8->23->25->26->27-баркодот почнува на 0, и цената е над 300.
6. allItems = [new Item("Kniga", "2648m", 100, 0.1f)], payment = 100 - 1->3->4.1->4.2->5->6->8->9->10->11.1->11.2->12->13->14->27- баркотот содржи буква и имаме зададено име.
7. allItems = [new Item("Kniga", "2468", 200, -1f)], payment = 2 - 1->3->4.1->4.2->5->6->8->9->10->11.1->11.2->12->13->11.1->11.2->15->17->18->21->4.3->4.2->23->24->27-вредноста на цената е помала од 300 и попустот има негативна вредност.


### Tест случаи според Multiple Condition критериумот:

        //TTF -враќа false
        ("2468", 310, 0.2f)
        //TFX -враќа false
        ("2468", 310, -1f)
        //TTT -враќа true
         ("0246", 310, 0.2f)
        //FXX-враќа false
         ("0246", 290, 0.2f)), 2)
-каде што Х е било која вредност.
