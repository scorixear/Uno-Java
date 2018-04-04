package server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: Paul Keller
 * date: 23.03.2018
 * version: 1.0
 */
public class Deck
{
    List<Card> cards = new ArrayList<>();
    Deck(String type){
        if(type.equals("full"))
        {
            for(int i=0;i<13;i++)
            {
                cards.add(new Card("red",i));
                cards.add(new Card("red",i));
                cards.add(new Card("green",i));
                cards.add(new Card("green",i));
                cards.add(new Card("blue",i));
                cards.add(new Card("blue",i));
                cards.add(new Card("yellow",i));
                cards.add(new Card("yellow",i));
            }
            for(int i=0;i<4;i++) {
                cards.add(new Card("black", 1));
                cards.add(new Card("black", 0));
            }
        }
    }

    public void addCard(Card... c)
    {
        cards.addAll(Arrays.asList(c));
    }
    public void removeCard(Card c)
    {
        cards.remove(c);
    }
    public Card drawCard(){
        Card c = cards.get(cards.size()-1);
        cards.remove(c);
        return c;
    }
    public int getSize(){
        return cards.size();
    }
    public Card drawDeckCard(Deck refill)
    {
        if(cards.size()==0)
        {
            refill(refill);
        }
        if(cards.size()==0)
        {
            return null;
        }
        Card c = cards.get(cards.size()-1);
        cards.remove(c);
        return c;
    }
    public void refill(Deck d)
    {
        while(d.getSize()>0)
        {
            addCard(d.drawCard());
        }
        shuffle();
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public void sort(){
        cards = cards.stream().sorted().collect(Collectors.toList());
    }
    public void printDeck(){
        cards.forEach(x-> System.out.println(x.toString()));
    }

    public boolean hasCard(Card c) {
        return cards.contains(c);
    }
}
