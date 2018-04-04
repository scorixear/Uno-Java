package server;

public class Card implements Comparable<Card>
{
    String color;
    int value;
    Card(String color, int value){
        this.color=color;
        this.value=value;
    }


    public String getColor(){
        return color;
    }

    public int getValue(){
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Card && ((Card)obj).getValue()==this.getValue()&&((Card)obj).getColor().equals(this.getColor()));
    }

    @Override
    public int compareTo(Card o) {
        if(o.getColor().equals(this.getColor()))
        {
            return Integer.compare(o.getValue(), this.getValue());
        }
        else
        {
            if(o.getColor().equals("red")||this.getColor().equals("black"))
            {
                return 1;
            }
            if(this.getColor().equals("red")||o.getColor().equals("black"))
            {
                return -1;
            }
            if(o.getColor().equals("yellow")||this.getColor().equals("blue"))
            {
                return 1;
            }
            if(this.getColor().equals("yellow")||o.getColor().equals("blue"))
            {
                return -1;
            }
        }
        return 0;
    }
    @Override
    public String toString(){
        if(!getColor().equals("black")) {
            if (getValue() < 10)
                return getColor() + " " + getValue();
            if (getValue()==10)
                return getColor()+" reverse";
            if(getValue()==11)
                return getColor()+" plus two";
            return getColor()+" interrupt";
        } else
        {
            if(getValue()==0)
                return getColor()+" wish";
            return getColor()+" plus four";
        }
    }
}
