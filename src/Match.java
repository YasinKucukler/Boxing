public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    
    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight)
    {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight= maxWeight;
    }

     public void run()
     {
         Fighter firstAttack = whoStart();
         if (isCheck()){
         while(this.f1.health > 0 && this.f2.health > 0)
         {
              System.out.println("-------------YENİ RAUND-------------");
                    if(firstAttack == f1){
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) break;
                    this.f1.health = this.f2.hit(this.f1);
              }else {
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) break;
                   this.f2.health = this.f1.hit(this.f2);
              }
              System.out.println(this.f1.name + " Sağlık : " + this.f1.health);
              System.out.println(this.f2.name + " Sağlık : " + this.f2.health);
         }
        }else
        {
            System.out.println("Sporcuların sikletlerleri uymuyor");
        }
     }
    
     boolean isCheck()
     {
          return(this.f1.weight >= minWeight && this.f1.weight <= maxWeight) &&
              (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
     }

     boolean isWin(){
         if(this.f1.health == 0 )
         {
              printWinner(f2.name);
              return true;
         }
         if (this.f2.health == 0)
         {
             printWinner(f1.name);
             return true;
         }
         return false;
    }
    public void printWinner(String figterName){
        System.out.println(figterName + " karşılaşmayı kazandı!!");
    }
    
    private Fighter whoStart()
    {
        double randomStart =  Math.random();
        System.out.println(randomStart);
        return (randomStart <= 0.5) ? f1:f2;
    }
}
